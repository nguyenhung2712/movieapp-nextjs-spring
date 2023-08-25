package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.repository.CinemaRepo;
import com.versolicitud.movieapp.service.ICinemaService;

@Service
public class CinemaService implements ICinemaService {

	@Autowired
	private CinemaRepo cinemaRepo;

	@Override
	public List<Cinema> getAll() {
		return this.cinemaRepo.findAll();
	}

	@Override
	public Cinema getById(UUID id) {
		Optional<Cinema> optional = this.cinemaRepo.findById(id);
		try {
			Cinema cinema = optional.orElseThrow(() -> new NoSuchElementException("Cinema not found"));
			return cinema;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Cinema save(Cinema cinema) {
		cinema.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return this.cinemaRepo.save(cinema);
	}

	@Override
	public void delete(UUID id) {
		this.cinemaRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Cinema> optional = this.cinemaRepo.findById(id);
		try {
			Cinema cinema = optional.orElseThrow(() -> new NoSuchElementException("Cinema not found"));
			int currentStt = cinema.getStatus();
			cinema.setStatus(currentStt == 1 ? 0 : 1);
			cinema.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.cinemaRepo.save(cinema);
		} catch (Exception e) {
			
		}
	}
	
}
