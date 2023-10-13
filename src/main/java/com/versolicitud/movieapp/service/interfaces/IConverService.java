package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.ConverDTO;
import com.versolicitud.movieapp.entity.Conver;

public interface IConverService {
    List<ConverDTO> getAll();

    ConverDTO getById(UUID id);

    ConverDTO save(ConverDTO conver);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
