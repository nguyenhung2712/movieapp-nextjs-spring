package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Schedule;

public interface IScheduleService {
	List<Schedule> getAll();
	Schedule getById(UUID id);
	Schedule save(Schedule schedule);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
