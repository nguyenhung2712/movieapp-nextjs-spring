package com.versolicitud.movieapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versolicitud.movieapp.entity.Seat;

@Repository
public interface SeatRepo extends JpaRepository<Seat, UUID> {

}
