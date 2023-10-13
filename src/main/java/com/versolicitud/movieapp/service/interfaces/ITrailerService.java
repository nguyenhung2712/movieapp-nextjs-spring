package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.TrailerDTO;
import com.versolicitud.movieapp.entity.Trailer;

public interface ITrailerService {
    List<TrailerDTO> getAll();

    TrailerDTO getById(UUID id);

    TrailerDTO save(TrailerDTO actor);

    void delete(UUID id);
}
