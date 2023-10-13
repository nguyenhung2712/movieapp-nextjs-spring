package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.CinemaDTO;
import com.versolicitud.movieapp.dto.RoomDTO;
import com.versolicitud.movieapp.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.entity.Room;
import com.versolicitud.movieapp.repository.RoomRepo;
import com.versolicitud.movieapp.service.interfaces.IRoomService;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private CinemaService cinemaService;

    @Override
    public RoomDTO getById(UUID id) {
        Optional<Room> optional = roomRepo.findById(id);
        try {
            Room rep = optional.orElseThrow(() -> new NoSuchElementException("Room not found"));
            return RoomMapper.MAPPER.mapToDTO(rep);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public RoomDTO save(RoomDTO room) {
        CinemaDTO cinema = cinemaService.getById(room.getCinema().getId());
        room.setCinema(cinema);

        Room savedRoom = RoomMapper.MAPPER.mapToEntity(room);
        return RoomMapper.MAPPER.mapToDTO(roomRepo.save(savedRoom));
    }

    @Override
    public void delete(UUID id) {
        roomRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Room> optional = roomRepo.findById(id);
        try {
            Room room = optional.orElseThrow(() -> new NoSuchElementException("Room not found"));
            int currentStt = room.getStatus();
            room.setStatus(currentStt == 1 ? 0 : 1);
            room.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            roomRepo.save(room);
        } catch (Exception e) {

        }
    }

}
