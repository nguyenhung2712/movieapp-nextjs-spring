package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private UUID id;

    private Timestamp showDate;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private MovieDTO movie;

    private CinemaDTO cinema;

//    private List<Ticket> tickets = new ArrayList<>();
}
