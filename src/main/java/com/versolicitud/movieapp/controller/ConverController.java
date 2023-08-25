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

import com.versolicitud.movieapp.entity.Conver;
import com.versolicitud.movieapp.service.impl.ConverService;

@RestController
@CrossOrigin
@RequestMapping("/api/conver")
public class ConverController {
	
	@Autowired
	private ConverService converService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Conver>> getAllConvers() {
		try {
			return new ResponseEntity<List<Conver>>(this.converService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conver> getConverById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Conver>(this.converService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveConver(@RequestBody Conver conver) throws URISyntaxException {
		Conver result = this.converService.save(conver);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleConver(@PathVariable("id") UUID id) throws URISyntaxException {
		this.converService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteConver(@PathVariable("id") UUID id) throws URISyntaxException {
		this.converService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
