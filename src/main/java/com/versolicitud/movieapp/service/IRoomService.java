package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Room;

public interface IRoomService {
	Room getById(UUID id);
	Room save(Room room);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
