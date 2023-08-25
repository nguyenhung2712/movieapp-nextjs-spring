package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Role;
import com.versolicitud.movieapp.repository.RoleRepo;
import com.versolicitud.movieapp.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public List<Role> getAll() {
		return this.roleRepo.findAll();
	}

	@Override
	public Role getById(Long id) {
		Optional<Role> optional = this.roleRepo.findById(id);
		try {
			Role role = optional.orElseThrow(() -> new NoSuchElementException("Role not found"));
			return role;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Role save(Role role) {
		role.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return this.roleRepo.save(role);
	}

	@Override
	public void delete(Long id) {
		this.roleRepo.deleteById(id);
	}

	@Override
	public Role getByName(String name) {
		Optional<Role> optional = this.roleRepo.findByName(name);
		try {
			Role role = optional.orElseThrow(() -> new NoSuchElementException("Role not found"));
			return role;
		} catch (Exception e) {
			return null;
		}
	}
}
