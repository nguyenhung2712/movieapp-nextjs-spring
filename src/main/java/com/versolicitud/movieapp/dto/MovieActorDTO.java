package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorDTO {
    private MovieDTO movie;

    private ActorDTO actor;

    private String charactorName;
}
