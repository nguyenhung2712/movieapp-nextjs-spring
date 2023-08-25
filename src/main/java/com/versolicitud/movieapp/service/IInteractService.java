package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Interact;

public interface IInteractService {
	Interact getById(UUID id);
	Interact save(Interact interact);
	void delete(UUID id);
}
