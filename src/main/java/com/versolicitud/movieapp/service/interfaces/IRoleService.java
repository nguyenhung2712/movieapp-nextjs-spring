package com.versolicitud.movieapp.service.interfaces;

import java.util.List;

import com.versolicitud.movieapp.dto.RoleDTO;
import com.versolicitud.movieapp.entity.Role;

public interface IRoleService {
    List<RoleDTO> getAll();

    RoleDTO getById(Long id);

    RoleDTO getByName(String name);

    RoleDTO save(RoleDTO role);

    void delete(Long id);
}
