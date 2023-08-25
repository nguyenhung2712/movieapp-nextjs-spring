package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Archive;

public interface IArchiveService {
	List<Archive> getAll();
	Archive getById(UUID id);
	Archive save(Archive archive);
	void delete(UUID id);
}
