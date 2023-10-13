package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.CommentDTO;
import com.versolicitud.movieapp.dto.RepDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.RepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Comment;
import com.versolicitud.movieapp.entity.Rep;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.RepRepo;
import com.versolicitud.movieapp.service.interfaces.IRepService;

@Service
public class RepService implements IRepService {

    @Autowired
    private RepRepo repRepo;

    @Autowired
    private CommentService cmtService;

    @Autowired
    private UserService userService;

    @Override
    public RepDTO getById(UUID id) {
        Optional<Rep> optional = repRepo.findById(id);
        try {
            Rep rep = optional.orElseThrow(() -> new NoSuchElementException("Comment Reply not found"));
            return RepMapper.MAPPER.mapToDTO(rep);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public RepDTO save(RepDTO rep) {
        CommentDTO cmt = cmtService.getById(rep.getComment().getId());
        UserDTO user = userService.getById(rep.getUser().getId());

        rep.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        rep.setUser(user);
        rep.setComment(cmt);

        Rep savedRep = RepMapper.MAPPER.mapToEntity(rep);
        return RepMapper.MAPPER.mapToDTO(repRepo.save(savedRep));
    }

    @Override
    public void delete(UUID id) {
        repRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Rep> optional = repRepo.findById(id);
        try {
            Rep rep = optional.orElseThrow(() -> new NoSuchElementException("Comment Reply not found"));
            int currentStt = rep.getStatus();
            rep.setStatus(currentStt == 1 ? 0 : 1);
            rep.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            repRepo.save(rep);
        } catch (Exception e) {

        }
    }

}
