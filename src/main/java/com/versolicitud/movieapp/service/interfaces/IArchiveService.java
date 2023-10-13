package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;
import java.util.List;

import com.versolicitud.movieapp.dto.ArchiveDTO;

public interface IArchiveService {
    List<ArchiveDTO> getAll();

    ArchiveDTO getById(UUID id);

    ArchiveDTO save(ArchiveDTO archive);

    void delete(UUID id);
}
