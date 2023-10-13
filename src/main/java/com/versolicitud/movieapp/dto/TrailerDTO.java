package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailerDTO {
    private UUID id;

    private String name;

    private String url;

    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private MovieDTO movie;
}
