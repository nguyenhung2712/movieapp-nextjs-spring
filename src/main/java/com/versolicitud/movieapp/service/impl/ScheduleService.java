package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.entity.Schedule;
import com.versolicitud.movieapp.repository.ScheduleRepo;
import com.versolicitud.movieapp.service.IScheduleService;

@Service
public class ScheduleService implements IScheduleService {

	@Autowired
	private ScheduleRepo scheduleRepo;
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private MovieService movieService;

	@Override
	public List<Schedule> getAll() {
		return this.scheduleRepo.findAll();
	}

	@Override
	public Schedule getById(UUID id) {
		Optional<Schedule> optional = this.scheduleRepo.findById(id);
		try {
			Schedule schedule = optional.orElseThrow(() -> new NoSuchElementException("Schedule not found"));
			return schedule;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Schedule save(Schedule schedule) {
		Movie movie = this.movieService.getById(schedule.getMovie().getId());
		Cinema cinema = this.cinemaService.getById(schedule.getCinema().getId());
		
		schedule.setMovie(movie);
		schedule.setCinema(cinema);
		
		return this.scheduleRepo.save(schedule);
	}

	@Override
	public void delete(UUID id) {
		this.scheduleRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Schedule> optional = this.scheduleRepo.findById(id);
		try {
			Schedule schedule = optional.orElseThrow(() -> new NoSuchElementException("Schedule not found"));
			int currentStt = schedule.getStatus();
			schedule.setStatus(currentStt == 1 ? 0 : 1);
			schedule.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.scheduleRepo.save(schedule);
		} catch (Exception e) {
			
		}
	}
	
}
