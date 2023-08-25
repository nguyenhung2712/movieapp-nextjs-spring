package com.versolicitud.movieapp.service;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.entity.Blog;

public interface IBlogService {
	List<Blog> getAll();
	Blog getById(UUID id);
	Blog save(Blog blog);
	void delete(UUID id);
	void toggleStatus(UUID id);
}
