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

import com.versolicitud.movieapp.entity.Rep;
import com.versolicitud.movieapp.service.impl.RepService;

@RestController
@CrossOrigin
@RequestMapping("/api/rep")
public class RepController {

	@Autowired
	private RepService repService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Rep> getRepById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Rep>(this.repService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRep(@RequestBody Rep rep) throws URISyntaxException {
		Rep result = this.repService.save(rep);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleRep(@PathVariable("id") UUID id) throws URISyntaxException {
		this.repService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteRep(@PathVariable("id") UUID id) throws URISyntaxException {
		this.repService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
