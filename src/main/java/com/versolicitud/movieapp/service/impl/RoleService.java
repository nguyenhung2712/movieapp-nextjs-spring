package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.RoleDTO;
import com.versolicitud.movieapp.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Role;
import com.versolicitud.movieapp.repository.RoleRepo;
import com.versolicitud.movieapp.service.interfaces.IRoleService;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<RoleDTO> getAll() {
        return roleRepo.findAll().stream()
                .map(RoleMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getById(Long id) {
        Optional<Role> optional = roleRepo.findById(id);
        try {
            Role role = optional.orElseThrow(() -> new NoSuchElementException("Role not found"));
            return RoleMapper.MAPPER.mapToDTO(role);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public RoleDTO save(RoleDTO role) {
        role.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Role savedRole = RoleMapper.MAPPER.mapToEntity(role);
        return RoleMapper.MAPPER.mapToDTO(roleRepo.save(savedRole));
    }

    @Override
    public void delete(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    public RoleDTO getByName(String name) {
        Optional<Role> optional = roleRepo.findByName(name);
        try {
            Role role = optional.orElseThrow(() -> new NoSuchElementException("Role not found"));
            return RoleMapper.MAPPER.mapToDTO(role);
        } catch (Exception e) {
            return null;
        }
    }
}
