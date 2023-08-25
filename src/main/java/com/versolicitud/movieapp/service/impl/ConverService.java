package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Conver;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.ConverRepo;
import com.versolicitud.movieapp.service.IConverService;

@Service
public class ConverService implements IConverService {

	@Autowired
	private ConverRepo converRepo;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Conver> getAll() {
		return this.converRepo.findAll();
	}

	@Override
	public Conver getById(UUID id) {
		Optional<Conver> optional = this.converRepo.findById(id);
		try {
			Conver conver = optional.orElseThrow(() -> new NoSuchElementException("Conver not found"));
			return conver;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Conver save(Conver conver) {
		User user = this.userService.getById(conver.getUser().getId());
		
		conver.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		conver.setUser(user);
		
		return this.converRepo.save(conver);
	}

	@Override
	public void delete(UUID id) {
		this.converRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Conver> optional = this.converRepo.findById(id);
		try {
			Conver conver = optional.orElseThrow(() -> new NoSuchElementException("Conversation not found"));
			int currentStt = conver.getStatus();
			conver.setStatus(currentStt == 1 ? 0 : 1);
			conver.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.converRepo.save(conver);
		} catch (Exception e) {
			
		}
	}
	
}
