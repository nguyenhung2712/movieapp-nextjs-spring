package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Permission;
import com.versolicitud.movieapp.repository.PermissionRepo;
import com.versolicitud.movieapp.service.IPermissionService;

@Service
public class PermissionService implements IPermissionService {

	@Autowired
	private PermissionRepo permissRepo;

	@Override
	public List<Permission> getAll() {
		return this.permissRepo.findAll();
	}

	@Override
	public Permission getById(Long id) {
		Optional<Permission> optional = this.permissRepo.findById(id);
		try {
			Permission permiss = optional.orElseThrow(() -> new NoSuchElementException("Permission not found"));
			return permiss;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Permission save(Permission permiss) {
		permiss.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return this.permissRepo.save(permiss);
	}

	@Override
	public void delete(Long id) {
		this.permissRepo.deleteById(id);
	}
	
}
