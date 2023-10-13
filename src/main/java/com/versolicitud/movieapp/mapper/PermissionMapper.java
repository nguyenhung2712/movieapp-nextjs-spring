package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.PermissionDTO;
import com.versolicitud.movieapp.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {
    PermissionMapper MAPPER = Mappers.getMapper(PermissionMapper.class);

    Permission mapToEntity(PermissionDTO dto);

    PermissionDTO mapToDTO(Permission entity);
}
