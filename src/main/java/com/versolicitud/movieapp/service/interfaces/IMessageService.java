package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.MessageDTO;
import com.versolicitud.movieapp.entity.Message;

public interface IMessageService {
    MessageDTO getById(UUID id);

    MessageDTO save(MessageDTO message);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
