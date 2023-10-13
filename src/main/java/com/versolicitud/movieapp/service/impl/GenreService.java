package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.GenreDTO;
import com.versolicitud.movieapp.mapper.GenreMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Genre;
import com.versolicitud.movieapp.repository.GenreRepo;
import com.versolicitud.movieapp.service.interfaces.IGenreService;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreRepo genreRepo;

    @Override
    public List<GenreDTO> getAll() {
        return genreRepo.findAll().stream()
                .map(GenreMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GenreDTO getById(UUID id) {
        Optional<Genre> optional = genreRepo.findById(id);
        try {
            Genre genre = optional.orElseThrow(() -> new NoSuchElementException("Genre not found"));
            return GenreMapper.MAPPER.mapToDTO(genre);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public GenreDTO save(GenreDTO genre) {
        genre.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Genre savedGenre = GenreMapper.MAPPER.mapToEntity(genre);
        return GenreMapper.MAPPER.mapToDTO(genreRepo.save(savedGenre));
    }

    @Override
    public void delete(UUID id) {
        genreRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Genre> optional = genreRepo.findById(id);
        try {
            Genre genre = optional.orElseThrow(() -> new NoSuchElementException("Genre not found"));
            int currentStt = genre.getStatus();
            genre.setStatus(currentStt == 1 ? 0 : 1);
            genre.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            genreRepo.save(genre);
        } catch (Exception e) {

        }
    }

}
