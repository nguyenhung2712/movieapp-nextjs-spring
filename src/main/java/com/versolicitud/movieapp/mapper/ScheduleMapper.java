package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.ScheduleDTO;
import com.versolicitud.movieapp.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper MAPPER = Mappers.getMapper(ScheduleMapper.class);

    Schedule mapToEntity(ScheduleDTO dto);

    ScheduleDTO mapToDTO(Schedule entity);
}
