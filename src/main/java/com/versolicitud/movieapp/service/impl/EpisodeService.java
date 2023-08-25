package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Episode;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.repository.EpisodeRepo;
import com.versolicitud.movieapp.service.IEpisodeService;

@Service
public class EpisodeService implements IEpisodeService {

	@Autowired
	private EpisodeRepo epRepo;
	
	@Autowired
	private MovieService movieService;

	@Override
	public Episode getById(UUID id) {
		Optional<Episode> optional = this.epRepo.findById(id);
		try {
			Episode ep = optional.orElseThrow(() -> new NoSuchElementException("Episode not found"));
			return ep;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Episode save(Episode ep) {
		Movie movie = this.movieService.getById(ep.getMovie().getId());
		ep.setMovie(movie);
		return this.epRepo.save(ep);
	}

	@Override
	public void delete(UUID id) {
		this.epRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Episode> optional = this.epRepo.findById(id);
		try {
			Episode ep = optional.orElseThrow(() -> new NoSuchElementException("Episode not found"));
			int currentStt = ep.getStatus();
			ep.setStatus(currentStt == 1 ? 0 : 1);
			ep.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.epRepo.save(ep);
		} catch (Exception e) {
			
		}
	}
	
}
