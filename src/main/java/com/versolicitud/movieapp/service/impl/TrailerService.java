package com.versolicitud.movieapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.dto.TrailerDTO;
import com.versolicitud.movieapp.mapper.TrailerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.entity.Trailer;
import com.versolicitud.movieapp.repository.TrailerRepo;
import com.versolicitud.movieapp.service.interfaces.ITrailerService;

public class TrailerService implements ITrailerService {

    @Autowired
    private TrailerRepo trailerRepo;

    @Autowired
    private MovieService movieService;

    @Override
    public List<TrailerDTO> getAll() {
        return trailerRepo.findAll().stream()
                .map(TrailerMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TrailerDTO getById(UUID id) {
        Optional<Trailer> optional = trailerRepo.findById(id);
        try {
            Trailer trailer = optional.orElseThrow(() -> new NoSuchElementException("Trailer not found"));
            return TrailerMapper.MAPPER.mapToDTO(trailer);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TrailerDTO save(TrailerDTO trailer) {
        MovieDTO movie = movieService.getById(trailer.getMovie().getId());
        trailer.setMovie(movie);

        Trailer savedTrailer = TrailerMapper.MAPPER.mapToEntity(trailer);
        return TrailerMapper.MAPPER.mapToDTO(trailerRepo.save(savedTrailer));
    }

    @Override
    public void delete(UUID id) {
        trailerRepo.deleteById(id);
    }

}
