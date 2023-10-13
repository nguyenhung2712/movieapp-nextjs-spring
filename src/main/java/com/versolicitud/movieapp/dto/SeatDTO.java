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
public class SeatDTO {
    private UUID id;

    private int rowNumb;

    private int colNumb;

    private int seatNumb;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private RoomDTO room;

//    private List<Ticket> tickets = new ArrayList<>();
}
