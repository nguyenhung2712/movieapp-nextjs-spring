package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private UUID id;

    private String name;

    private int capacity;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

//    private List<Seat> seats = new ArrayList<>();

    private CinemaDTO cinema;
}
