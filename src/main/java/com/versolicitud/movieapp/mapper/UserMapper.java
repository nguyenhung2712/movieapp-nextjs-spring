package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User mapToEntity(UserDTO dto);

    UserDTO mapToDTO(User entity);
}
