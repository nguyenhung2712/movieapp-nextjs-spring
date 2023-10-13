package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.BookingDTO;
import com.versolicitud.movieapp.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {
    BookingMapper MAPPER = Mappers.getMapper(BookingMapper.class);

    Booking mapToEntity(BookingDTO dto);

    BookingDTO mapToDTO(Booking entity);
}
