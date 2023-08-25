package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Conver;

public interface IConverService {
	List<Conver> getAll();
	Conver getById(UUID id);
	Conver save(Conver conver);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
