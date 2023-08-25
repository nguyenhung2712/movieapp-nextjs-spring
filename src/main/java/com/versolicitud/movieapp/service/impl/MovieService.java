package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Genre;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.repository.MovieRepo;
import com.versolicitud.movieapp.service.IMovieService;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private GenreService genreService;

	@Override
	public List<Movie> getAll() {
		return this.movieRepo.findAll();
	}

	@Override
	public Movie getById(UUID id) {
		Optional<Movie> optional = this.movieRepo.findById(id);
		try {
			Movie movie = optional.orElseThrow(() -> new NoSuchElementException("Movie not found"));
			return movie;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Movie save(Movie movie) {
		Genre genre = this.genreService.getById(movie.getGenre().getId());
		
		movie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		movie.setGenre(genre);
		
		return this.movieRepo.save(movie);
	}

	@Override
	public void delete(UUID id) {
		this.movieRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Movie> optional = this.movieRepo.findById(id);
		try {
			Movie movie = optional.orElseThrow(() -> new NoSuchElementException("Movie not found"));
			int currentStt = movie.getStatus();
			movie.setStatus(currentStt == 1 ? 0 : 1);
			movie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.movieRepo.save(movie);
		} catch (Exception e) {
			
		}
	}
	
}
