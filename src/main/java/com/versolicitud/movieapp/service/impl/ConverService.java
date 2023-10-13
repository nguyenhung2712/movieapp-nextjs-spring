package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.ConverDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.ConverMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Conver;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.ConverRepo;
import com.versolicitud.movieapp.service.interfaces.IConverService;

@Service
public class ConverService implements IConverService {

    @Autowired
    private ConverRepo converRepo;

    @Autowired
    private UserService userService;

    @Override
    public List<ConverDTO> getAll() {
        return converRepo.findAll().stream()
                .map(ConverMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConverDTO getById(UUID id) {
        Optional<Conver> optional = converRepo.findById(id);
        try {
            Conver conver = optional.orElseThrow(() -> new NoSuchElementException("Conver not found"));
            return ConverMapper.MAPPER.mapToDTO(conver);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ConverDTO save(ConverDTO conver) {
        UserDTO user = userService.getById(conver.getUser().getId());

        conver.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        conver.setUser(user);

        Conver savedConver = ConverMapper.MAPPER.mapToEntity(conver);
        
        return ConverMapper.MAPPER.mapToDTO(converRepo.save(savedConver));
    }

    @Override
    public void delete(UUID id) {
        converRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Conver> optional = converRepo.findById(id);
        try {
            Conver conver = optional.orElseThrow(() -> new NoSuchElementException("Conversation not found"));
            int currentStt = conver.getStatus();
            conver.setStatus(currentStt == 1 ? 0 : 1);
            conver.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            converRepo.save(conver);
        } catch (Exception e) {

        }
    }

}
