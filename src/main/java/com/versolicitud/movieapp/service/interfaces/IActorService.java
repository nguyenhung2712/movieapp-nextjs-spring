package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.ActorDTO;

public interface IActorService {
    List<ActorDTO> getAll();

    ActorDTO getById(UUID id);

    ActorDTO save(ActorDTO actor);

    void delete(UUID id);
}
