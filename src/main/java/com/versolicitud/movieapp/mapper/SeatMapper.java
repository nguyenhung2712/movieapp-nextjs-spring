package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.SeatDTO;
import com.versolicitud.movieapp.entity.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatMapper {
    SeatMapper MAPPER = Mappers.getMapper(SeatMapper.class);

    Seat mapToEntity(SeatDTO dto);

    SeatDTO mapToDTO(Seat entity);
}
