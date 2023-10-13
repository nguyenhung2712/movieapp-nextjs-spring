package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveDTO {
    private UUID id;

    private String name;

    private int type;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private UserDTO user;

    private BlogDTO blog;

    private MovieDTO movie;
}
