package com.versolicitud.movieapp.service.interfaces;

import java.util.Map;

import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.payload.request.LoginRequest;
import com.versolicitud.movieapp.payload.request.RegisterRequest;

public interface IAuthService {
    Map<String, Object> login(LoginRequest loginRq);

    User register(RegisterRequest registerRq);
}
