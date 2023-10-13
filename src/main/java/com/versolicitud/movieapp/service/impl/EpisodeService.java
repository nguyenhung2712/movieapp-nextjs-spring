package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.EpisodeDTO;
import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.mapper.EpisodeMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Episode;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.repository.EpisodeRepo;
import com.versolicitud.movieapp.service.interfaces.IEpisodeService;

@Service
public class EpisodeService implements IEpisodeService {

    @Autowired
    private EpisodeRepo epRepo;

    @Autowired
    private MovieService movieService;

    @Override
    public EpisodeDTO getById(UUID id) {
        Optional<Episode> optional = epRepo.findById(id);
        try {
            Episode ep = optional.orElseThrow(() -> new NoSuchElementException("Episode not found"));
            return EpisodeMapper.MAPPER.mapToDTO(ep);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public EpisodeDTO save(EpisodeDTO ep) {
        MovieDTO movie = movieService.getById(ep.getMovie().getId());
        ep.setMovie(movie);

        Episode savedEp = EpisodeMapper.MAPPER.mapToEntity(ep);
        return EpisodeMapper.MAPPER.mapToDTO(epRepo.save(savedEp));
    }

    @Override
    public void delete(UUID id) {
        epRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Episode> optional = epRepo.findById(id);
        try {
            Episode ep = optional.orElseThrow(() -> new NoSuchElementException("Episode not found"));
            int currentStt = ep.getStatus();
            ep.setStatus(currentStt == 1 ? 0 : 1);
            ep.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            epRepo.save(ep);
        } catch (Exception e) {

        }
    }

}
