package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.ScheduleDTO;
import com.versolicitud.movieapp.entity.Schedule;

public interface IScheduleService {
    List<ScheduleDTO> getAll();

    ScheduleDTO getById(UUID id);

    ScheduleDTO save(ScheduleDTO schedule);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
