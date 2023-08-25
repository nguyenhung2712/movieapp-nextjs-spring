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

import com.versolicitud.movieapp.entity.Interact;
import com.versolicitud.movieapp.service.impl.InteractService;

@RestController
@CrossOrigin
@RequestMapping("/api/interact")
public class InteractController {
	
	@Autowired
	private InteractService interactService;	
	
	@GetMapping("/{id}")
	public ResponseEntity<Interact> getInteractById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Interact>(this.interactService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveInteract(@RequestBody Interact interact) throws URISyntaxException {
		Interact result = this.interactService.save(interact);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteInteract(@PathVariable("id") UUID id) throws URISyntaxException {
		this.interactService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
