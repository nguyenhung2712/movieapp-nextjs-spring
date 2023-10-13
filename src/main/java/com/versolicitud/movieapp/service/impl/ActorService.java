package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.ActorDTO;
import com.versolicitud.movieapp.mapper.ActorMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Actor;
import com.versolicitud.movieapp.repository.ActorRepo;
import com.versolicitud.movieapp.service.interfaces.IActorService;

@Service
public class ActorService implements IActorService {

    @Autowired
    private ActorRepo actorRepo;

    @Override
    public List<ActorDTO> getAll() {
        return actorRepo.findAll().stream()
                .map(ActorMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActorDTO getById(UUID id) {
        Optional<Actor> optional = actorRepo.findById(id);
        try {
            Actor actor = optional.orElseThrow(() -> new NoSuchElementException("Actor not found"));
            return ActorMapper.MAPPER.mapToDTO(actor);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ActorDTO save(ActorDTO actor) {
        actor.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Actor savedActor = ActorMapper.MAPPER.mapToEntity(actor);
        return ActorMapper.MAPPER.mapToDTO(actorRepo.save(savedActor));
    }

    @Override
    public void delete(UUID id) {
        actorRepo.deleteById(id);
    }

}
