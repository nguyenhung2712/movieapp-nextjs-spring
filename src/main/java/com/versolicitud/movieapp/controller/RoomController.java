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

import com.versolicitud.movieapp.entity.Room;
import com.versolicitud.movieapp.service.impl.RoomService;

@RestController
@CrossOrigin
@RequestMapping("/api/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Room>(this.roomService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRoom(@RequestBody Room room) throws URISyntaxException {
		Room result = this.roomService.save(room);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleRoom(@PathVariable("id") UUID id) throws URISyntaxException {
		this.roomService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable("id") UUID id) throws URISyntaxException {
		this.roomService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
