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

import com.versolicitud.movieapp.entity.Schedule;
import com.versolicitud.movieapp.service.impl.ScheduleService;

@RestController
@CrossOrigin
@RequestMapping("/api/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/all")
	public ResponseEntity<List<Schedule>> getAllSchedules() {
		try {
			return new ResponseEntity<List<Schedule>>(this.scheduleService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Schedule>(this.scheduleService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveSchedule(@RequestBody Schedule schedule) throws URISyntaxException {
		Schedule result = scheduleService.save(schedule);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleSchedule(@PathVariable("id") UUID id) throws URISyntaxException {
		this.scheduleService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteSchedule(@PathVariable("id") UUID id) throws URISyntaxException {
		this.scheduleService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
