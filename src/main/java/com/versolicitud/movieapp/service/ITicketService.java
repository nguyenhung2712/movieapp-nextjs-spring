package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Ticket;

public interface ITicketService {
	List<Ticket> getAll();
	Ticket getById(UUID id);
	Ticket save(Ticket ticket);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
