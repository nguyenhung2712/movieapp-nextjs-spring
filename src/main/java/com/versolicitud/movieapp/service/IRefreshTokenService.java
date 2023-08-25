package com.versolicitud.movieapp.service;

import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.entity.RefreshToken;
import com.versolicitud.movieapp.entity.User;

public interface IRefreshTokenService {
	Optional<RefreshToken> findByToken(String token);
	RefreshToken findByUser(User user);
	RefreshToken createRefreshToken(UUID userId);
	RefreshToken verifyExpiration(RefreshToken token);
	int deleteByUserId(UUID userId);
}
