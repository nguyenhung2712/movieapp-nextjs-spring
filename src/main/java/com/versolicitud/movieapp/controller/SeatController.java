package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
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

import com.versolicitud.movieapp.entity.Seat;
import com.versolicitud.movieapp.service.impl.SeatService;

@RestController
@CrossOrigin
@RequestMapping("/api/seat")
public class SeatController {
	
	@Autowired
	private SeatService seatService;

	@GetMapping("/{id}")
	public ResponseEntity<Seat> getSeatById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Seat>(this.seatService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveSeat(@RequestBody Seat seat) throws URISyntaxException {
		Seat result = this.seatService.save(seat);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleSeat(@PathVariable("id") UUID id) throws URISyntaxException {
		this.seatService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteSeat(@PathVariable("id") UUID id) throws URISyntaxException {
		this.seatService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
