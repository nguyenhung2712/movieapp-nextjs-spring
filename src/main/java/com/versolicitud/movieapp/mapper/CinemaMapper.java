package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.CinemaDTO;
import com.versolicitud.movieapp.entity.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CinemaMapper {
    CinemaMapper MAPPER = Mappers.getMapper(CinemaMapper.class);

    Cinema mapToEntity(CinemaDTO dto);

    CinemaDTO mapToDTO(Cinema entity);
}
