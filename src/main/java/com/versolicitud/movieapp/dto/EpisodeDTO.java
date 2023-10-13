package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    private UUID id;

    private String name;

    private String ordinalNumber;

    private String description;

    private int duration;

    private int status;

    private Timestamp releasedAt;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private MovieDTO movie;
}
