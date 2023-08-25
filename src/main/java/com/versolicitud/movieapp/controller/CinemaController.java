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

import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.service.impl.CinemaService;

@RestController
@CrossOrigin
@RequestMapping("/api/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;

	@GetMapping("/all")
	public ResponseEntity<List<Cinema>> getAllCinemas() {
		try {
			return new ResponseEntity<List<Cinema>>(this.cinemaService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cinema> getCinemaById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Cinema>(this.cinemaService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> saveCinema(@RequestBody Cinema cinema) throws URISyntaxException {
		Cinema result = this.cinemaService.save(cinema);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleCinema(@PathVariable("id") UUID id) throws URISyntaxException {
		this.cinemaService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteCinema(@PathVariable("id") UUID id) throws URISyntaxException {
		this.cinemaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
