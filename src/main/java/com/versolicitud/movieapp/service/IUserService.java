package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.User;

public interface IUserService {
	List<User> getAll();
	User getById(UUID id);
	User getByUsernameOrEmail(String usernameOrEmail);
	User save(User user);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
