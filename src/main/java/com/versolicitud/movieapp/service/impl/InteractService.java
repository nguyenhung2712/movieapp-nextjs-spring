package com.versolicitud.movieapp.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.*;
import com.versolicitud.movieapp.mapper.InteractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.Cinema;
import com.versolicitud.movieapp.entity.Comment;
import com.versolicitud.movieapp.entity.Interact;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.entity.Rep;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.InteractRepo;
import com.versolicitud.movieapp.service.interfaces.IInteractService;

@Service
public class InteractService implements IInteractService {

    @Autowired
    private InteractRepo interactRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private RepService repService;

    @Autowired
    private CommentService cmtService;

    @Autowired
    private MovieService movieService;

    @Override
    public InteractDTO getById(UUID id) {
        Optional<Interact> optional = interactRepo.findById(id);
        try {
            Interact interact = optional.orElseThrow(() -> new NoSuchElementException("Interaction not found"));
            return InteractMapper.MAPPER.mapToDTO(interact);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public InteractDTO save(InteractDTO interact) {
        UserDTO user = userService.getById(interact.getUser().getId());
        BlogDTO blog = blogService.getById(interact.getBlog().getId());
        CinemaDTO cinema = cinemaService.getById(interact.getCinema().getId());
        RepDTO rep = repService.getById(interact.getRep().getId());
        CommentDTO cmt = cmtService.getById(interact.getComment().getId());
        MovieDTO movie = movieService.getById(interact.getMovie().getId());

        interact.setUser(user);
        if (blog != null) {
            interact.setBlog(blog);
        }
        if (cinema != null) {
            interact.setCinema(cinema);
        }
        if (rep != null) {
            interact.setRep(rep);
        }
        if (cmt != null) {
            interact.setComment(cmt);
        }
        if (movie != null) {
            interact.setMovie(movie);
        }

        Interact savedInteract = InteractMapper.MAPPER.mapToEntity(interact);

        return InteractMapper.MAPPER.mapToDTO(interactRepo.save(savedInteract));
    }

    @Override
    public void delete(UUID id) {
        interactRepo.deleteById(id);
    }

}
