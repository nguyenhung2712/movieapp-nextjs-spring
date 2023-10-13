package com.versolicitud.movieapp.dto;

import com.versolicitud.movieapp.entity.*;
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
public class MovieDTO {
    private UUID id;

    private String title;

    private String director;

    private String description;

    private int duration;

    private int status;

    private String slug;

    private Timestamp releasedAt;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private GenreDTO genre;

//    private List<MovieActor> movieActors = new ArrayList<>();
//
//    private List<Interact> interacts = new ArrayList<>();
//
//    private List<Archive> archives = new ArrayList<>();
//
//    private List<Schedule> schedules = new ArrayList<>();
//
//    private List<Episode> episodes = new ArrayList<>();
//
//    private List<Trailer> trailers = new ArrayList<>();

}
