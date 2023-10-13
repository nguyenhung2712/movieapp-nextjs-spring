package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.MovieActorDTO;
import com.versolicitud.movieapp.entity.MovieActor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieActorMapper {
    MovieActorMapper MAPPER = Mappers.getMapper(MovieActorMapper.class);

    MovieActor mapToEntity(MovieActorDTO dto);

    MovieActorDTO mapToDTO(MovieActor entity);
}
