package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private UUID id;

    private BigDecimal price;

    private int status;

    private Timestamp createdAt;

    private BookingDTO booking;

    private ScheduleDTO schedule;

    private SeatDTO seat;
}
