package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private UUID id;

    private UserDTO user;

//    private List<Ticket> tickets = new ArrayList<>();
}
