package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.CinemaDTO;
import com.versolicitud.movieapp.entity.Cinema;

public interface ICinemaService {
    List<CinemaDTO> getAll();

    CinemaDTO getById(UUID id);

    CinemaDTO save(CinemaDTO cinema);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
