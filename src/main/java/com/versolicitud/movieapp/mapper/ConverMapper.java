package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.ConverDTO;
import com.versolicitud.movieapp.entity.Conver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConverMapper {
    ConverMapper MAPPER = Mappers.getMapper(ConverMapper.class);

    Conver mapToEntity(ConverDTO dto);

    ConverDTO mapToDTO(Conver entity);
}
