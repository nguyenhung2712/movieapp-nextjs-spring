package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.CinemaDTO;
import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.dto.ScheduleDTO;
import com.versolicitud.movieapp.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.entity.Schedule;
import com.versolicitud.movieapp.repository.ScheduleRepo;
import com.versolicitud.movieapp.service.interfaces.IScheduleService;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @Override
    public List<ScheduleDTO> getAll() {
        return this.scheduleRepo.findAll().stream()
                .map(ScheduleMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO getById(UUID id) {
        Optional<Schedule> optional = this.scheduleRepo.findById(id);
        try {
            Schedule schedule = optional.orElseThrow(() -> new NoSuchElementException("Schedule not found"));
            return ScheduleMapper.MAPPER.mapToDTO(schedule);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ScheduleDTO save(ScheduleDTO schedule) {
        MovieDTO movie = this.movieService.getById(schedule.getMovie().getId());
        CinemaDTO cinema = this.cinemaService.getById(schedule.getCinema().getId());

        schedule.setMovie(movie);
        schedule.setCinema(cinema);

        Schedule savedSchedule = ScheduleMapper.MAPPER.mapToEntity(schedule);
        return ScheduleMapper.MAPPER.mapToDTO(scheduleRepo.save(savedSchedule));
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
