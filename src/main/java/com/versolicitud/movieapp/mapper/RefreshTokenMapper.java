package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.RefreshTokenDTO;
import com.versolicitud.movieapp.entity.RefreshToken;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RefreshTokenMapper {
    RefreshTokenMapper MAPPER = Mappers.getMapper(RefreshTokenMapper.class);

    RefreshToken mapToEntity(RefreshTokenDTO dto);

    RefreshTokenDTO mapToDTO(RefreshToken entity);
}
