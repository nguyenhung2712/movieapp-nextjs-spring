package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.ActivityHistory;
import com.versolicitud.movieapp.repository.ActiHistoryRepo;
import com.versolicitud.movieapp.service.IActiHistoryService;

@Service
public class ActiHistoryService implements IActiHistoryService {
	
	@Autowired
	private ActiHistoryRepo activeRepo;

	@Override
	public List<ActivityHistory> getAll() {
		return this.activeRepo.findAll();
	}

	@Override
	public ActivityHistory getById(UUID id) {
		Optional<ActivityHistory> optional = this.activeRepo.findById(id);
		try {
			ActivityHistory history = optional.orElseThrow(() -> new NoSuchElementException("History not found"));
			
			return history;
		} catch (Exception e) {
			return null;	
		}
	}

	@Override
	public ActivityHistory save(ActivityHistory actiHistory) {
		return this.activeRepo.save(actiHistory);
	}

	@Override
	public void delete(UUID id) {
		this.activeRepo.deleteById(id);
	}

}
