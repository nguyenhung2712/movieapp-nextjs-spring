package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Genre;

public interface IGenreService {
	List<Genre> getAll();
	Genre getById(UUID id);
	Genre save(Genre genre);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
