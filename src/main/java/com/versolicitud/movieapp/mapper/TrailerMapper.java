package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.TrailerDTO;
import com.versolicitud.movieapp.entity.Trailer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrailerMapper {
    TrailerMapper MAPPER = Mappers.getMapper(TrailerMapper.class);

    Trailer mapToEntity(TrailerDTO dto);

    TrailerDTO mapToDTO(Trailer entity);
}
