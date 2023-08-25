package com.versolicitud.movieapp.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.MovieActor;
import com.versolicitud.movieapp.entity.combine_id.MovieActorPK;
import com.versolicitud.movieapp.repository.MovieActorRepo;
import com.versolicitud.movieapp.service.IMovieActorService;

@Service
public class MovieActorService implements IMovieActorService {

	@Autowired
	private MovieActorRepo maRepo;

	@Override
	public MovieActor save(MovieActor mActor) {
		return this.maRepo.save(mActor);
	}

	@Override
	public void delete(UUID movieId, UUID actorId) {
		this.maRepo.deleteById(new MovieActorPK(movieId, actorId));
	}
	
}
