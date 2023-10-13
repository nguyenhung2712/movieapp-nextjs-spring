package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.MessageDTO;
import com.versolicitud.movieapp.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);

    Message mapToEntity(MessageDTO dto);

    MessageDTO mapToDTO(Message entity);
}
