package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.RoomDTO;
import com.versolicitud.movieapp.entity.Room;

public interface IRoomService {
    RoomDTO getById(UUID id);

    RoomDTO save(RoomDTO room);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
