package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Booking;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.BookingRepo;
import com.versolicitud.movieapp.service.IBookingService;

@Service
public class BookingService implements IBookingService {

	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Booking> getAll() {
		return this.bookingRepo.findAll();
	}

	@Override
	public Booking getById(UUID id) {
		Optional<Booking> optional = this.bookingRepo.findById(id);
		try {
			Booking booking = optional.orElseThrow(() -> new NoSuchElementException("Booking not found"));
			return booking;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Booking save(Booking booking) {
		User user = this.userService.getById(booking.getUser().getId());
		booking.setUser(user);
		return this.bookingRepo.save(booking);
	}

	@Override
	public void delete(UUID id) {
		this.bookingRepo.deleteById(id);
	}
	
}
