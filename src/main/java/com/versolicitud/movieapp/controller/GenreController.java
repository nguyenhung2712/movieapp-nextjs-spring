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

import com.versolicitud.movieapp.entity.Genre;
import com.versolicitud.movieapp.service.impl.GenreService;

@RestController
@CrossOrigin
@RequestMapping("/api/genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Genre>> getAllGenres() {
		try {
			return new ResponseEntity<List<Genre>>(this.genreService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genre> getGenreById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Genre>(this.genreService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveGenre(@RequestBody Genre genre) throws URISyntaxException {
		Genre result = this.genreService.save(genre);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteGenre(@PathVariable("id") UUID id) throws URISyntaxException {
		this.genreService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
