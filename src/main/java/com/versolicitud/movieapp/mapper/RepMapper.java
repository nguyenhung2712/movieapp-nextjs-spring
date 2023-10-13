package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.RepDTO;
import com.versolicitud.movieapp.entity.Rep;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepMapper {
    RepMapper MAPPER = Mappers.getMapper(RepMapper.class);

    Rep mapToEntity(RepDTO dto);

    RepDTO mapToDTO(Rep entity);
}
