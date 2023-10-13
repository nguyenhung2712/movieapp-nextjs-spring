package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.RoomDTO;
import com.versolicitud.movieapp.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper MAPPER = Mappers.getMapper(RoomMapper.class);

    Room mapToEntity(RoomDTO dto);

    RoomDTO mapToDTO(Room entity);
}
