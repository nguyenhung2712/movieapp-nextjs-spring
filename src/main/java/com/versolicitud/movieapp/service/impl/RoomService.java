package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.entity.Room;
import com.versolicitud.movieapp.repository.RoomRepo;
import com.versolicitud.movieapp.service.IRoomService;

@Service
public class RoomService implements IRoomService {

	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired
	private CinemaService cinemaService;

	@Override
	public Room getById(UUID id) {
		Optional<Room> optional = this.roomRepo.findById(id);
		try {
			Room rep = optional.orElseThrow(() -> new NoSuchElementException("Room not found"));
			return rep;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Room save(Room room) {
		Cinema cinema = this.cinemaService.getById(room.getCinema().getId());
		room.setCinema(cinema);
		return this.roomRepo.save(room);
	}

	@Override
	public void delete(UUID id) {
		this.roomRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Room> optional = this.roomRepo.findById(id);
		try {
			Room room = optional.orElseThrow(() -> new NoSuchElementException("Room not found"));
			int currentStt = room.getStatus();
			room.setStatus(currentStt == 1 ? 0 : 1);
			room.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.roomRepo.save(room);
		} catch (Exception e) {
			
		}
	}
	
}
