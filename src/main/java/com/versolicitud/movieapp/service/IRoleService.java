package com.versolicitud.movieapp.service;

import java.util.List;

import com.versolicitud.movieapp.entity.Role;

public interface IRoleService {
	List<Role> getAll();
	Role getById(Long id);
	Role getByName(String name);
	Role save(Role role);
	void delete(Long id);
}
