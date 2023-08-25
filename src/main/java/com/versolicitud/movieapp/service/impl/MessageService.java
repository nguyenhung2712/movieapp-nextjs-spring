package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Conver;
import com.versolicitud.movieapp.entity.Message;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.MessageRepo;
import com.versolicitud.movieapp.service.IMessageService;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private ConverService converService;

	@Autowired
	private UserService userService;

	@Override
	public Message getById(UUID id) {
		Optional<Message> optional = this.messageRepo.findById(id);
		try {
			Message message = optional.orElseThrow(() -> new NoSuchElementException("Message not found"));
			return message;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Message save(Message message) {
		Conver conver = this.converService.getById(message.getConver().getId());
		User user = this.userService.getById(message.getUser().getId());
		
		message.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		message.setConver(conver);
		message.setUser(user);
		
		return this.messageRepo.save(message);
	}

	@Override
	public void delete(UUID id) {
		this.messageRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Message> optional = this.messageRepo.findById(id);
		try {
			Message message = optional.orElseThrow(() -> new NoSuchElementException("Message not found"));
			int currentStt = message.getStatus();
			message.setStatus(currentStt == 1 ? 0 : 1);
			message.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.messageRepo.save(message);
		} catch (Exception e) {
			
		}
	}
	
}
