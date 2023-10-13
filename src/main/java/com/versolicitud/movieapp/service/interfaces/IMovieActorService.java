package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.MovieActorDTO;
import com.versolicitud.movieapp.entity.MovieActor;

public interface IMovieActorService {
    MovieActorDTO save(MovieActorDTO mActor);

    void delete(UUID movieId, UUID actorId);
}
