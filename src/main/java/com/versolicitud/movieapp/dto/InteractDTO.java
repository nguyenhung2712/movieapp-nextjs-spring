package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InteractDTO {
    private UUID id;

    private int type;

    private Timestamp createdAt;

    private UserDTO user;

    private BlogDTO blog;

    private CommentDTO comment;

    private RepDTO rep;

    private MovieDTO movie;

    private CinemaDTO cinema;
}
