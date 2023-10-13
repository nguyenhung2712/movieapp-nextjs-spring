package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.GenreDTO;
import com.versolicitud.movieapp.entity.Genre;

public interface IGenreService {
    List<GenreDTO> getAll();

    GenreDTO getById(UUID id);

    GenreDTO save(GenreDTO genre);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
