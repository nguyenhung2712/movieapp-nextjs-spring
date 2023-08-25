package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Room;
import com.versolicitud.movieapp.entity.Seat;
import com.versolicitud.movieapp.repository.SeatRepo;
import com.versolicitud.movieapp.service.ISeatService;

@Service
public class SeatService implements ISeatService {

	@Autowired
	private SeatRepo seatRepo;
	
	@Autowired
	private RoomService roomService;

	@Override
	public Seat getById(UUID id) {
		Optional<Seat> optional = this.seatRepo.findById(id);
		try {
			Seat seat = optional.orElseThrow(() -> new NoSuchElementException("Seat not found"));
			return seat;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Seat save(Seat seat) {
		Room room = this.roomService.getById(seat.getRoom().getId());
		
		seat.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		seat.setRoom(room);
		
		return this.seatRepo.save(seat);
	}

	@Override
	public void delete(UUID id) {
		this.seatRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Seat> optional = this.seatRepo.findById(id);
		try {
			Seat seat = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
			int currentStt = seat.getStatus();
			seat.setStatus(currentStt == 1 ? 0 : 1);
			seat.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.seatRepo.save(seat);
		} catch (Exception e) {
			
		}
	}
	
}
