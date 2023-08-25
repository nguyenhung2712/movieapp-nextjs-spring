package com.versolicitud.movieapp.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenRefreshResponse {
	 private String accessToken;
	 private String refreshToken;
}
