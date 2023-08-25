package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Genre;
import com.versolicitud.movieapp.repository.GenreRepo;
import com.versolicitud.movieapp.service.IGenreService;

@Service
public class GenreService implements IGenreService {
	
	@Autowired
	private GenreRepo genreRepo;

	@Override
	public List<Genre> getAll() {
		return this.genreRepo.findAll();
	}

	@Override
	public Genre getById(UUID id) {
		Optional<Genre> optional = this.genreRepo.findById(id);
		try {
			Genre genre = optional.orElseThrow(() -> new NoSuchElementException("Genre not found"));
			return genre;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Genre save(Genre genre) {
		genre.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return this.genreRepo.save(genre);
	}

	@Override
	public void delete(UUID id) {
		this.genreRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Genre> optional = this.genreRepo.findById(id);
		try {
			Genre genre = optional.orElseThrow(() -> new NoSuchElementException("Genre not found"));
			int currentStt = genre.getStatus();
			genre.setStatus(currentStt == 1 ? 0 : 1);
			genre.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.genreRepo.save(genre);
		} catch (Exception e) {
			
		}
	}

}
