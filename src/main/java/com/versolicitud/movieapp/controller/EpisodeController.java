package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.Episode;
import com.versolicitud.movieapp.service.impl.EpisodeService;

@RestController
@CrossOrigin
@RequestMapping("/api/episode")
public class EpisodeController {
	
	@Autowired
	private EpisodeService epService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Episode> getEpisodeById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Episode>(this.epService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEpisode(@RequestBody Episode ep) throws URISyntaxException {
		Episode result = this.epService.save(ep);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleEpisode(@PathVariable("id") UUID id) throws URISyntaxException {
		this.epService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEpisode(@PathVariable("id") UUID id) throws URISyntaxException {
		this.epService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
