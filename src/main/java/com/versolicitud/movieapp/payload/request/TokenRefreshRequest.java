package com.versolicitud.movieapp.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TokenRefreshRequest {
	@NotBlank
	private String refreshToken;
}
