package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.entity.Movie;

public interface IMovieService {
    List<MovieDTO> getAll();

    MovieDTO getById(UUID id);

    MovieDTO save(MovieDTO movie);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
