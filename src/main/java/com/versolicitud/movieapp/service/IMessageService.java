package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Message;

public interface IMessageService {
	Message getById(UUID id);
	Message save(Message message);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
