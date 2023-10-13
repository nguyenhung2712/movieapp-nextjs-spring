package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.RoomDTO;
import com.versolicitud.movieapp.dto.SeatDTO;
import com.versolicitud.movieapp.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Room;
import com.versolicitud.movieapp.entity.Seat;
import com.versolicitud.movieapp.repository.SeatRepo;
import com.versolicitud.movieapp.service.interfaces.ISeatService;

@Service
public class SeatService implements ISeatService {

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private RoomService roomService;

    @Override
    public SeatDTO getById(UUID id) {
        Optional<Seat> optional = seatRepo.findById(id);
        try {
            Seat seat = optional.orElseThrow(() -> new NoSuchElementException("Seat not found"));
            return SeatMapper.MAPPER.mapToDTO(seat);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SeatDTO save(SeatDTO seat) {
        RoomDTO room = roomService.getById(seat.getRoom().getId());

        seat.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        seat.setRoom(room);

        Seat savedSeat = SeatMapper.MAPPER.mapToEntity(seat);
        return SeatMapper.MAPPER.mapToDTO(seatRepo.save(savedSeat));
    }

    @Override
    public void delete(UUID id) {
        seatRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Seat> optional = seatRepo.findById(id);
        try {
            Seat seat = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
            int currentStt = seat.getStatus();
            seat.setStatus(currentStt == 1 ? 0 : 1);
            seat.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            seatRepo.save(seat);
        } catch (Exception e) {

        }
    }

}
