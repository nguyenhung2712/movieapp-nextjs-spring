package com.versolicitud.movieapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.versolicitud.movieapp.entity.RefreshToken;
import com.versolicitud.movieapp.entity.User;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Long> {
	Optional<RefreshToken> findByToken(String token);
	Optional<RefreshToken> findByUser(User user);
	
	@Modifying
	int deleteByUser(User user);
}
