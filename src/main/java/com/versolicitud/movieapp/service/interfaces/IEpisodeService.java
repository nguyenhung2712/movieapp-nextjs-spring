package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.EpisodeDTO;
import com.versolicitud.movieapp.entity.Episode;

public interface IEpisodeService {
    EpisodeDTO getById(UUID id);

    EpisodeDTO save(EpisodeDTO ep);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
