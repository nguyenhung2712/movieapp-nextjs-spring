package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.EpisodeDTO;
import com.versolicitud.movieapp.entity.Episode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EpisodeMapper {
    EpisodeMapper MAPPER = Mappers.getMapper(EpisodeMapper.class);

    Episode mapToEntity(EpisodeDTO dto);

    EpisodeDTO mapToDTO(Episode entity);
}
