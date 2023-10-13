package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.UserDTO;

public interface IUserService {
    List<UserDTO> getAll();

    UserDTO getById(UUID id);

    UserDTO getByUsernameOrEmail(String usernameOrEmail);

    UserDTO save(UserDTO user);

    void delete(UUID id);

    void toggleStatus(UUID id);

    void authorizeUser(UUID userId, Long[] roleIds);

    boolean checkExistedUsername(String username);

    boolean checkExistedEmail(String email);
}
