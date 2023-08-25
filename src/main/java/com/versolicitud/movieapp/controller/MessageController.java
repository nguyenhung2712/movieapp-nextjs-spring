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

import com.versolicitud.movieapp.entity.Message;
import com.versolicitud.movieapp.service.impl.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/api/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Message>(this.messageService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveMessage(@RequestBody Message message) throws URISyntaxException {
		Message result = this.messageService.save(message);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleMessage(@PathVariable("id") UUID id) throws URISyntaxException {
		this.messageService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteMessage(@PathVariable("id") UUID id) throws URISyntaxException {
		this.messageService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
