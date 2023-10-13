package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.BookingDTO;
import com.versolicitud.movieapp.dto.ScheduleDTO;
import com.versolicitud.movieapp.dto.SeatDTO;
import com.versolicitud.movieapp.dto.TicketDTO;
import com.versolicitud.movieapp.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Booking;
import com.versolicitud.movieapp.entity.Schedule;
import com.versolicitud.movieapp.entity.Seat;
import com.versolicitud.movieapp.entity.Ticket;
import com.versolicitud.movieapp.repository.TicketRepo;
import com.versolicitud.movieapp.service.interfaces.ITicketService;

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
    public List<TicketDTO> getAll() {
        return ticketRepo.findAll().stream()
                .map(TicketMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO getById(UUID id) {
        Optional<Ticket> optional = ticketRepo.findById(id);
        try {
            Ticket ticket = optional.orElseThrow(() -> new NoSuchElementException("Ticket not found"));
            return TicketMapper.MAPPER.mapToDTO(ticket);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TicketDTO save(TicketDTO ticket) {
        SeatDTO seat = seatService.getById(ticket.getSeat().getId());
        ScheduleDTO schedule = scheduleService.getById(ticket.getSchedule().getId());
        BookingDTO booking = bookingService.getById(ticket.getBooking().getId());

        ticket.setSeat(seat);
        ticket.setSchedule(schedule);
        ticket.setBooking(booking);

        Ticket savedTicket = TicketMapper.MAPPER.mapToEntity(ticket);
        
        return TicketMapper.MAPPER.mapToDTO(ticketRepo.save(savedTicket));
    }

    @Override
    public void delete(UUID id) {
        ticketRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Ticket> optional = ticketRepo.findById(id);
        try {
            Ticket ticket = optional.orElseThrow(() -> new NoSuchElementException("Ticket not found"));
            int currentStt = ticket.getStatus();
            ticket.setStatus(currentStt == 1 ? 0 : 1);
            ticketRepo.save(ticket);
        } catch (Exception e) {

        }
    }
}
