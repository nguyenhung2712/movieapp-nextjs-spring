package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.InteractDTO;
import com.versolicitud.movieapp.entity.Interact;

public interface IInteractService {
    InteractDTO getById(UUID id);

    InteractDTO save(InteractDTO interact);

    void delete(UUID id);
}
