package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Seat;

public interface ISeatService {
	Seat getById(UUID id);
	Seat save(Seat seat);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
