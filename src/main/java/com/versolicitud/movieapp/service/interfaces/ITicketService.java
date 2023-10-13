package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.TicketDTO;
import com.versolicitud.movieapp.entity.Ticket;

public interface ITicketService {
    List<TicketDTO> getAll();

    TicketDTO getById(UUID id);

    TicketDTO save(TicketDTO ticket);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
