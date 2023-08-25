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

import com.versolicitud.movieapp.entity.ActivityHistory;
import com.versolicitud.movieapp.service.impl.ActiHistoryService;

@RestController
@CrossOrigin
@RequestMapping("/api/acti-history")
public class ActiHistoryController {
	
	@Autowired
	private ActiHistoryService historyService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ActivityHistory>> getAllHistories() {
		try {
			return new ResponseEntity<List<ActivityHistory>>(this.historyService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ActivityHistory> getHistoryById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<ActivityHistory>(this.historyService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveHistory(@RequestBody ActivityHistory history) throws URISyntaxException {
		ActivityHistory result = this.historyService.save(history);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteHistory(@PathVariable("id") UUID id) throws URISyntaxException {
		this.historyService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
