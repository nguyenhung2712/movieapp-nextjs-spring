package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.ArchiveDTO;
import com.versolicitud.movieapp.entity.Archive;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArchiveMapper {
    ArchiveMapper MAPPER = Mappers.getMapper(ArchiveMapper.class);

    Archive mapToEntity(ArchiveDTO dto);

    ArchiveDTO mapToDTO(Archive entity);
}
