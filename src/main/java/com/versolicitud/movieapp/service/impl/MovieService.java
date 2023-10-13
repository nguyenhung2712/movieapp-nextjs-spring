package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.GenreDTO;
import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Genre;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.repository.MovieRepo;
import com.versolicitud.movieapp.service.interfaces.IMovieService;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private GenreService genreService;

    @Override
    public List<MovieDTO> getAll() {
        return movieRepo.findAll().stream()
                .map(MovieMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getById(UUID id) {
        Optional<Movie> optional = movieRepo.findById(id);
        try {
            Movie movie = optional.orElseThrow(() -> new NoSuchElementException("Movie not found"));
            return MovieMapper.MAPPER.mapToDTO(movie);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public MovieDTO save(MovieDTO movie) {
        GenreDTO genre = genreService.getById(movie.getGenre().getId());

        movie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        movie.setGenre(genre);

        Movie savedMovie = MovieMapper.MAPPER.mapToEntity(movie);
        return MovieMapper.MAPPER.mapToDTO(movieRepo.save(savedMovie));
    }

    @Override
    public void delete(UUID id) {
        movieRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Movie> optional = movieRepo.findById(id);
        try {
            Movie movie = optional.orElseThrow(() -> new NoSuchElementException("Movie not found"));
            int currentStt = movie.getStatus();
            movie.setStatus(currentStt == 1 ? 0 : 1);
            movie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            movieRepo.save(movie);
        } catch (Exception e) {

        }
    }

}
