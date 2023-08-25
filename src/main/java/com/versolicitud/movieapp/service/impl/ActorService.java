package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Actor;
import com.versolicitud.movieapp.repository.ActorRepo;
import com.versolicitud.movieapp.service.IActorService;

@Service
public class ActorService implements IActorService {
	
	@Autowired
	private ActorRepo actorRepo;

	@Override
	public List<Actor> getAll() {
		return this.actorRepo.findAll();
	}

	@Override
	public Actor getById(UUID id) {
		Optional<Actor> optional = this.actorRepo.findById(id);
		try {
			Actor actor = optional.orElseThrow(() -> new NoSuchElementException("Actor not found"));
			return actor;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Actor save(Actor actor) {
		actor.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return this.actorRepo.save(actor);
	}

	@Override
	public void delete(UUID id) {
		this.actorRepo.deleteById(id);
	}

}
