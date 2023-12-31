package com.versolicitud.movieapp.service.impl;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.RefreshTokenDTO;
import com.versolicitud.movieapp.mapper.RefreshTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.RefreshToken;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.exceptions.TokenRefreshException;
import com.versolicitud.movieapp.repository.RefreshTokenRepo;
import com.versolicitud.movieapp.repository.UserRepo;
import com.versolicitud.movieapp.service.interfaces.IRefreshTokenService;

@Service
public class RefreshTokenService implements IRefreshTokenService {

    @Value("${movie.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepo refTokenRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return this.refTokenRepo.findByToken(token);
    }

    @Override
    public RefreshTokenDTO createRefreshToken(UUID userId) {
        RefreshToken refToken = new RefreshToken();

        refToken.setUser(userRepo.findById(userId).get());
        refToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refToken.setToken(UUID.randomUUID().toString());

        refToken = refTokenRepo.save(refToken);
        return RefreshTokenMapper.MAPPER.mapToDTO(refToken);
    }

    @Override
    public RefreshTokenDTO verifyExpiration(RefreshTokenDTO token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refTokenRepo.delete(RefreshTokenMapper.MAPPER.mapToEntity(token));
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

    @Override
    public int deleteByUserId(UUID userId) {
        return refTokenRepo.deleteByUser(userRepo.findById(userId).get());
    }

    @Override
    public RefreshTokenDTO findByUser(User user) {
        Optional<RefreshToken> optional = this.refTokenRepo.findByUser(user);
        try {
            RefreshToken ref = optional.orElseThrow(() -> new NoSuchElementException("Refresh Token not found"));
            return RefreshTokenMapper.MAPPER.mapToDTO(ref);
        } catch (Exception e) {
            return null;
        }
    }

}
