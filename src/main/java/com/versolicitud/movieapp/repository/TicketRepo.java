package com.versolicitud.movieapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versolicitud.movieapp.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, UUID> {

}
