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

import com.versolicitud.movieapp.entity.Ticket;
import com.versolicitud.movieapp.service.impl.TicketService;

@RestController
@CrossOrigin
@RequestMapping("/api/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		try {
			return new ResponseEntity<List<Ticket>>(this.ticketService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Ticket>(this.ticketService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveTicket(@RequestBody Ticket ticket) throws URISyntaxException {
		Ticket result = ticketService.save(ticket);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleTicket(@PathVariable("id") UUID id) throws URISyntaxException {
		this.ticketService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteTicket(@PathVariable("id") UUID id) throws URISyntaxException {
		this.ticketService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
