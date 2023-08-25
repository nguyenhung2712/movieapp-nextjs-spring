package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.MovieActor;

public interface IMovieActorService {
	MovieActor save(MovieActor mActor);
	void delete(UUID movieId, UUID actorId);
}
