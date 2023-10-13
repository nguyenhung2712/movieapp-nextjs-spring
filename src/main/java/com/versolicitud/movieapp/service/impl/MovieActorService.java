package com.versolicitud.movieapp.service.impl;

import java.util.UUID;

import com.versolicitud.movieapp.dto.ActorDTO;
import com.versolicitud.movieapp.dto.MovieActorDTO;
import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.mapper.MovieActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.MovieActor;
import com.versolicitud.movieapp.entity.combine_id.MovieActorPK;
import com.versolicitud.movieapp.repository.MovieActorRepo;
import com.versolicitud.movieapp.service.interfaces.IMovieActorService;

@Service
public class MovieActorService implements IMovieActorService {

    @Autowired
    private MovieActorRepo maRepo;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @Override
    public MovieActorDTO save(MovieActorDTO mActor) {
        MovieDTO movie = movieService.getById(mActor.getMovie().getId());
        ActorDTO actor = actorService.getById(mActor.getActor().getId());
        mActor.setActor(actor);
        mActor.setMovie(movie);

        MovieActor savedValue = MovieActorMapper.MAPPER.mapToEntity(mActor);
        return MovieActorMapper.MAPPER.mapToDTO(maRepo.save(savedValue));
    }

    @Override
    public void delete(UUID movieId, UUID actorId) {
        maRepo.deleteById(new MovieActorPK(movieId, actorId));
    }

}
