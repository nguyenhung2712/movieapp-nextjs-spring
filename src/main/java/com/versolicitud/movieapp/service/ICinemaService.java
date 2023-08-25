package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Cinema;

public interface ICinemaService {
	List<Cinema> getAll();
	Cinema getById(UUID id);
	Cinema save(Cinema cinema);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
