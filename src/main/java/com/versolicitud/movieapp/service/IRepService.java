package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Rep;

public interface IRepService {
	Rep getById(UUID id);
	Rep save(Rep rep);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
