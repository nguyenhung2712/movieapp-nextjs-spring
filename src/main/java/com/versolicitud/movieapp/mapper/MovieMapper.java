package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper MAPPER = Mappers.getMapper(MovieMapper.class);

    Movie mapToEntity(MovieDTO dto);

    MovieDTO mapToDTO(Movie entity);
}
