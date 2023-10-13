package com.versolicitud.movieapp.service.interfaces;

import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.RefreshTokenDTO;
import com.versolicitud.movieapp.entity.RefreshToken;
import com.versolicitud.movieapp.entity.User;

public interface IRefreshTokenService {
    Optional<RefreshToken> findByToken(String token);

    RefreshTokenDTO findByUser(User user);

    RefreshTokenDTO createRefreshToken(UUID userId);

    RefreshTokenDTO verifyExpiration(RefreshTokenDTO token);

    int deleteByUserId(UUID userId);
}
