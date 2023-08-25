package com.versolicitud.movieapp.service;

import java.util.UUID;

import com.versolicitud.movieapp.entity.Comment;

public interface ICommentService {
	Comment getById(UUID id);
	Comment save(Comment comment);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
