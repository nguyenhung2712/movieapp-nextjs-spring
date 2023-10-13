package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.ActorDTO;
import com.versolicitud.movieapp.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {
    ActorMapper MAPPER = Mappers.getMapper(ActorMapper.class);

    Actor mapToEntity(ActorDTO dto);

    ActorDTO mapToDTO(Actor entity);
}
