package com.versolicitud.movieapp.service;

import java.util.List;

import com.versolicitud.movieapp.entity.Permission;

public interface IPermissionService {
	List<Permission> getAll();
	Permission getById(Long id);
	Permission save(Permission permission);
	void delete(Long id);
}
