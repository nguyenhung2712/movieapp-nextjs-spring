package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Booking;
import com.versolicitud.movieapp.entity.Schedule;
import com.versolicitud.movieapp.entity.Seat;
import com.versolicitud.movieapp.entity.Ticket;
import com.versolicitud.movieapp.repository.TicketRepo;
import com.versolicitud.movieapp.service.ITicketService;

@Service
public class TicketService implements ITicketService {
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private SeatService seatService;

	@Override
	public List<Ticket> getAll() {
		return this.ticketRepo.findAll();
	}

	@Override
	public Ticket getById(UUID id) {
		Optional<Ticket> optional = this.ticketRepo.findById(id);
		try {
			Ticket ticket = optional.orElseThrow(() -> new NoSuchElementException("Ticket not found"));
			
			return ticket;
		} catch (Exception e) {
			return null;	
		}
	}

	@Override
	public Ticket save(Ticket ticket) {
		Seat seat = this.seatService.getById(ticket.getSeat().getId());
		Schedule schedule = this.scheduleService.getById(ticket.getSchedule().getId());
		Booking booking = this.bookingService.getById(ticket.getBooking().getId());
		
		ticket.setSeat(seat);
		ticket.setSchedule(schedule);
		ticket.setBooking(booking);
		return this.ticketRepo.save(ticket);
	}

	@Override
	public void delete(UUID id) {
		this.ticketRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Ticket> optional = this.ticketRepo.findById(id);
		try {
			Ticket ticket = optional.orElseThrow(() -> new NoSuchElementException("Ticket not found"));
			int currentStt = ticket.getStatus();
			ticket.setStatus(currentStt == 1 ? 0 : 1);
			this.ticketRepo.save(ticket);
		} catch (Exception e) {
			
		}
	}
}
