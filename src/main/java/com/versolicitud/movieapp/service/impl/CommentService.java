package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.versolicitud.movieapp.dto.BlogDTO;
import com.versolicitud.movieapp.dto.CommentDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.CommentMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.Comment;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.CommentRepo;
import com.versolicitud.movieapp.service.interfaces.ICommentService;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepo cmtRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Override
    public CommentDTO getById(UUID id) {
        Optional<Comment> optional = cmtRepo.findById(id);
        try {
            Comment cmt = optional.orElseThrow(() -> new NoSuchElementException("Comment not found"));
            return CommentMapper.MAPPER.mapToDTO(cmt);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public CommentDTO save(CommentDTO cmt) {
        UserDTO user = userService.getById(cmt.getUser().getId());
        BlogDTO blog = blogService.getById(cmt.getBlog().getId());

        cmt.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        cmt.setUser(user);
        cmt.setBlog(blog);

        Comment savedCmt = CommentMapper.MAPPER.mapToEntity(cmt);

        return CommentMapper.MAPPER.mapToDTO(cmtRepo.save(savedCmt));
    }

    @Override
    public void delete(UUID id) {
        cmtRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Comment> optional = cmtRepo.findById(id);
        try {
            Comment cmt = optional.orElseThrow(() -> new NoSuchElementException("Comment not found"));
            int currentStt = cmt.getStatus();
            cmt.setStatus(currentStt == 1 ? 0 : 1);
            cmt.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            cmtRepo.save(cmt);
        } catch (Exception e) {

        }
    }

}
