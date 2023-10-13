package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.SeatDTO;
import com.versolicitud.movieapp.entity.Seat;

public interface ISeatService {
    SeatDTO getById(UUID id);

    SeatDTO save(SeatDTO seat);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
