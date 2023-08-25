package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.Actor;
import com.versolicitud.movieapp.service.impl.ActorService;

@RestController
@CrossOrigin
@RequestMapping("/api/actor")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Actor>> getAllActors() {
		try {
			return new ResponseEntity<List<Actor>>(this.actorService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Actor>(this.actorService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveActor(@RequestBody Actor actor) throws URISyntaxException {
		Actor result = this.actorService.save(actor);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable("id") UUID id) throws URISyntaxException {
		this.actorService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
