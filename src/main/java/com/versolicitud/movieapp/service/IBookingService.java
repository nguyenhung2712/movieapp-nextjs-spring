package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Booking;

public interface IBookingService {
	List<Booking> getAll();
	Booking getById(UUID id);
	Booking save(Booking booking);
	void delete(UUID id);
}
