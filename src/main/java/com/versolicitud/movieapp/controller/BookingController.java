package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.Booking;
import com.versolicitud.movieapp.service.impl.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Booking>> getAllBookings() {
		try {
			return new ResponseEntity<List<Booking>>(this.bookingService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Booking>(this.bookingService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBooking(@RequestBody Booking booking) throws URISyntaxException {

		Booking result = this.bookingService.save(booking);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable("id") UUID id) throws URISyntaxException {
		this.bookingService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
