package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.ActivityHistoryDTO;

public interface IActiHistoryService {
    List<ActivityHistoryDTO> getAll();

    ActivityHistoryDTO getById(UUID id);

    ActivityHistoryDTO save(ActivityHistoryDTO actiHistory);

    void delete(UUID id);
}
