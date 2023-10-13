package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.ArchiveDTO;
import com.versolicitud.movieapp.dto.BlogDTO;
import com.versolicitud.movieapp.dto.MovieDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.ActorMapper;
import com.versolicitud.movieapp.mapper.ArchiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Archive;
import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.ArchiveRepo;
import com.versolicitud.movieapp.service.interfaces.IArchiveService;

@Service
public class ArchiveService implements IArchiveService {

    @Autowired
    private ArchiveRepo archiveRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private MovieService movieService;

    @Override
    public List<ArchiveDTO> getAll() {
        return archiveRepo.findAll().stream()
                .map(ArchiveMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArchiveDTO getById(UUID id) {
        Optional<Archive> optional = archiveRepo.findById(id);
        try {
            Archive archive = optional.orElseThrow(() -> new NoSuchElementException("Archive not found"));
            return ArchiveMapper.MAPPER.mapToDTO(archive);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArchiveDTO save(ArchiveDTO archive) {
        BlogDTO blog = blogService.getById(archive.getBlog().getId());
        UserDTO user = userService.getById(archive.getBlog().getId());
        MovieDTO movie = movieService.getById(archive.getBlog().getId());

        archive.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        archive.setBlog(blog);
        archive.setUser(user);
        archive.setMovie(movie);
        Archive savedArchive = ArchiveMapper.MAPPER.mapToEntity(archive);
        return ArchiveMapper.MAPPER.mapToDTO(archiveRepo.save(savedArchive));
    }

    @Override
    public void delete(UUID id) {
        archiveRepo.deleteById(id);
    }

}
