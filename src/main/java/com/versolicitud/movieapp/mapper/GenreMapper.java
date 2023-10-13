package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.GenreDTO;
import com.versolicitud.movieapp.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper MAPPER = Mappers.getMapper(GenreMapper.class);

    Genre mapToEntity(GenreDTO dto);

    GenreDTO mapToDTO(Genre entity);
}
