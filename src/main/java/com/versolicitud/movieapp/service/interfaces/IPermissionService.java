package com.versolicitud.movieapp.service.interfaces;

import java.util.List;

import com.versolicitud.movieapp.dto.PermissionDTO;
import com.versolicitud.movieapp.entity.Permission;

public interface IPermissionService {
    List<PermissionDTO> getAll();

    PermissionDTO getById(Long id);

    PermissionDTO save(PermissionDTO permission);

    void delete(Long id);
}
