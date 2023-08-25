package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Episode;

public interface IEpisodeService {
	Episode getById(UUID id);
	Episode save(Episode ep);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
