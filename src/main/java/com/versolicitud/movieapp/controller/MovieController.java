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

import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.service.impl.MovieService;

@RestController
@CrossOrigin
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getAllMovies() {
		try {
			return new ResponseEntity<List<Movie>>(this.movieService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Movie>(this.movieService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws URISyntaxException {
		Movie result = this.movieService.save(movie);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleMovie(@PathVariable("id") UUID id) throws URISyntaxException {
		this.movieService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id) throws URISyntaxException {
		this.movieService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
