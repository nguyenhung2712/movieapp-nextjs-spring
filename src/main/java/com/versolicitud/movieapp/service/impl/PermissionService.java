package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.PermissionDTO;
import com.versolicitud.movieapp.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Permission;
import com.versolicitud.movieapp.repository.PermissionRepo;
import com.versolicitud.movieapp.service.interfaces.IPermissionService;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private PermissionRepo permissRepo;

    @Override
    public List<PermissionDTO> getAll() {
        return permissRepo.findAll().stream()
                .map(PermissionMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PermissionDTO getById(Long id) {
        Optional<Permission> optional = permissRepo.findById(id);
        try {
            Permission permiss = optional.orElseThrow(() -> new NoSuchElementException("Permission not found"));
            return PermissionMapper.MAPPER.mapToDTO(permiss);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PermissionDTO save(PermissionDTO permiss) {
        permiss.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Permission savedPerm = PermissionMapper.MAPPER.mapToEntity(permiss);
        return PermissionMapper.MAPPER.mapToDTO(permissRepo.save(savedPerm));
    }

    @Override
    public void delete(Long id) {
        permissRepo.deleteById(id);
    }

}
