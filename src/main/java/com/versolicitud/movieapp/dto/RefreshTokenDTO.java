package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenDTO {
    private Long id;

    private String token;

    private Instant expiryDate;

    private UserDTO user;
}
