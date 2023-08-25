package com.versolicitud.movieapp.payload.response;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	private String token;
	private UUID id;
	private String username;
	private String email;
	private List<String> roles;
}
