package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.RepDTO;
import com.versolicitud.movieapp.entity.Rep;

public interface IRepService {
    RepDTO getById(UUID id);

    RepDTO save(RepDTO rep);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
