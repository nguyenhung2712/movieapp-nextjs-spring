package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.ConverDTO;
import com.versolicitud.movieapp.dto.MessageDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Conver;
import com.versolicitud.movieapp.entity.Message;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.MessageRepo;
import com.versolicitud.movieapp.service.interfaces.IMessageService;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ConverService converService;

    @Autowired
    private UserService userService;

    @Override
    public MessageDTO getById(UUID id) {
        Optional<Message> optional = messageRepo.findById(id);
        try {
            Message message = optional.orElseThrow(() -> new NoSuchElementException("Message not found"));
            return MessageMapper.MAPPER.mapToDTO(message);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public MessageDTO save(MessageDTO message) {
        ConverDTO conver = converService.getById(message.getConver().getId());
        UserDTO user = userService.getById(message.getUser().getId());

        message.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        message.setConver(conver);
        message.setUser(user);

        Message savedMessage = MessageMapper.MAPPER.mapToEntity(message);
        return MessageMapper.MAPPER.mapToDTO(messageRepo.save(savedMessage));
    }

    @Override
    public void delete(UUID id) {
        messageRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Message> optional = messageRepo.findById(id);
        try {
            Message message = optional.orElseThrow(() -> new NoSuchElementException("Message not found"));
            int currentStt = message.getStatus();
            message.setStatus(currentStt == 1 ? 0 : 1);
            message.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            messageRepo.save(message);
        } catch (Exception e) {

        }
    }

}
