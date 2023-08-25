package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Actor;

public interface IActorService {
	List<Actor> getAll();
	Actor getById(UUID id);
	Actor save(Actor actor);
	void delete(UUID id);
}
