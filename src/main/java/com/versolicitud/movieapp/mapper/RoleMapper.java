package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.RoleDTO;
import com.versolicitud.movieapp.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

    Role mapToEntity(RoleDTO dto);

    RoleDTO mapToDTO(Role entity);
}
