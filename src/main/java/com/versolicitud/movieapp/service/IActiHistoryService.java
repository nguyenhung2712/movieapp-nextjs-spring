package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.ActivityHistory;

public interface IActiHistoryService {
	List<ActivityHistory> getAll();
	ActivityHistory getById(UUID id);
	ActivityHistory save(ActivityHistory actiHistory);
	void delete(UUID id);
}
