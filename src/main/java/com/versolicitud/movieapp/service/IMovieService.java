package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Movie;

public interface IMovieService {
	List<Movie> getAll();
	Movie getById(UUID id);
	Movie save(Movie movie);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
