package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.InteractDTO;
import com.versolicitud.movieapp.entity.Interact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InteractMapper {
    InteractMapper MAPPER = Mappers.getMapper(InteractMapper.class);

    Interact mapToEntity(InteractDTO dto);

    InteractDTO mapToDTO(Interact entity);
}
