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

import com.versolicitud.movieapp.entity.Archive;
import com.versolicitud.movieapp.service.impl.ArchiveService;

@RestController
@CrossOrigin
@RequestMapping("/api/archive")
public class ArchiveController {

	@Autowired
	private ArchiveService archiveService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Archive>> getAllArchives() {
		try {
			return new ResponseEntity<List<Archive>>(this.archiveService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Archive> getArchiveById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Archive>(this.archiveService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveArchive(@RequestBody Archive archive) throws URISyntaxException {
		Archive result = this.archiveService.save(archive);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteArchive(@PathVariable("id") UUID id) throws URISyntaxException {
		this.archiveService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
