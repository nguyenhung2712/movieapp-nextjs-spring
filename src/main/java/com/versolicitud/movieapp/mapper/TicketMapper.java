package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.TicketDTO;
import com.versolicitud.movieapp.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper MAPPER = Mappers.getMapper(TicketMapper.class);

    Ticket mapToEntity(TicketDTO dto);

    TicketDTO mapToDTO(Ticket entity);
}
