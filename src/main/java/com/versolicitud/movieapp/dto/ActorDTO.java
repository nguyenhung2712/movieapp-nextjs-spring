package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private UUID id;

    private String fullname;

    private Date dob;

    private String bio;

    private int status;

    @CreationTimestamp
    private Timestamp createdAt;

    private Timestamp updatedAt;

//    private List<MovieActor> movieActors = new ArrayList<>();
}
