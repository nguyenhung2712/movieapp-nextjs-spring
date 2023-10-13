package com.versolicitud.movieapp.service.interfaces;

import java.util.UUID;

import com.versolicitud.movieapp.dto.CommentDTO;
import com.versolicitud.movieapp.entity.Comment;

public interface ICommentService {
    CommentDTO getById(UUID id);

    CommentDTO save(CommentDTO comment);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
