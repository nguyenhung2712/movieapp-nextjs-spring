package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.ActivityHistoryDTO;
import com.versolicitud.movieapp.mapper.ActHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.ActivityHistory;
import com.versolicitud.movieapp.repository.ActiHistoryRepo;
import com.versolicitud.movieapp.service.interfaces.IActiHistoryService;

@Service
public class ActiHistoryService implements IActiHistoryService {

    @Autowired
    private ActiHistoryRepo activeRepo;

    @Override
    public List<ActivityHistoryDTO> getAll() {
        return activeRepo.findAll().stream()
                .map(ActHistoryMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityHistoryDTO getById(UUID id) {
        Optional<ActivityHistory> optional = activeRepo.findById(id);
        try {
            ActivityHistory history = optional.orElseThrow(() -> new NoSuchElementException("History not found"));
            return ActHistoryMapper.MAPPER.mapToDTO(history);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ActivityHistoryDTO save(ActivityHistoryDTO actiHistory) {
        ActivityHistory history = ActHistoryMapper.MAPPER.mapToEntity(actiHistory);
        return ActHistoryMapper.MAPPER.mapToDTO(activeRepo.save(history));
    }

    @Override
    public void delete(UUID id) {
        activeRepo.deleteById(id);
    }

}
