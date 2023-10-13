package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.RoleDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.RoleMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Role;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.UserRepo;
import com.versolicitud.movieapp.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll().stream()
                .map(UserMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(UUID id) {
        Optional<User> optional = this.userRepo.findById(id);
        try {
            User user = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
            return UserMapper.MAPPER.mapToDTO(user);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDTO getByUsernameOrEmail(String usernameOrEmail) {
        Optional<User> optional = this.userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
        try {
            User user = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
            return UserMapper.MAPPER.mapToDTO(user);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        this.userRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<User> optional = this.userRepo.findById(id);
        try {
            User user = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
            int currentStt = user.getStatus();
            user.setStatus(currentStt == 1 ? 0 : 1);
            user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            this.userRepo.save(user);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public UserDTO save(UserDTO user) {
        Set<RoleDTO> roles = new HashSet<>();
        RoleDTO userRole = roleService.getById((long) 3);
        roles.add(userRole);

        User entity = UserMapper.MAPPER.mapToEntity(user);
        entity.setRoles(roles.stream().map(RoleMapper.MAPPER::mapToEntity).collect(Collectors.toSet()));
        entity.setPassword(encoder.encode(entity.getPassword()));
        entity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return UserMapper.MAPPER.mapToDTO(userRepo.save(entity));
    }

    @Override
    public boolean checkExistedUsername(String username) {
        return this.userRepo.existsByUsername(username);
    }

    @Override
    public boolean checkExistedEmail(String email) {
        return this.userRepo.existsByEmail(email);
    }

    @Override
    public void authorizeUser(UUID userId, Long[] roleIds) {
        try {
            User user = this.userRepo.findById(userId).get();
            Set<RoleDTO> newRoles = new HashSet<>();
            for (Long roleId : roleIds) {
                RoleDTO role = this.roleService.getById((long) roleId);
                newRoles.add(role);
            }
            user.setRoles(newRoles.stream().map(RoleMapper.MAPPER::mapToEntity).collect(Collectors.toSet()));

            this.userRepo.save(user);
        } catch (Exception e) {
            return;
        }
    }
}
