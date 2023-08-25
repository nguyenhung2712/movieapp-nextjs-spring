package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Role;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.UserRepo;
import com.versolicitud.movieapp.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public List<User> getAll() {
		return this.userRepo.findAll();
	}

	@Override
	public User getById(UUID id) {
		Optional<User> optional = this.userRepo.findById(id);
		try {
			User user = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public User getByUsernameOrEmail(String usernameOrEmail) {
		Optional<User> optional = this.userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
		try {
			User user = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(UUID id) {
		this.userRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<User> optional = this.userRepo.findById(id);
		try {
			User user = optional.orElseThrow(() -> new NoSuchElementException("User not found"));
			int currentStt = user.getStatus();
			user.setStatus(currentStt == 1 ? 0 : 1);
			user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.userRepo.save(user);
		} catch (Exception e) {
			
		}
	}

	@Override
	public User save(User user) {
		Set<Role> roles = new HashSet<>();
		Role userRole = this.roleService.getById((long) 3);
		roles.add(userRole);
		
		user.setRoles(roles);
		user.setPassword(encoder.encode(user.getPassword()));
		user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		return this.userRepo.save(user);
	}
}
