package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.ActivityHistoryDTO;
import com.versolicitud.movieapp.entity.ActivityHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActHistoryMapper {
    ActHistoryMapper MAPPER = Mappers.getMapper(ActHistoryMapper.class);

    ActivityHistory mapToEntity(ActivityHistoryDTO dto);

    ActivityHistoryDTO mapToDTO(ActivityHistory entity);
}
