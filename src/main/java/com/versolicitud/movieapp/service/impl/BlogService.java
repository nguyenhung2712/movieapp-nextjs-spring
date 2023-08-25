package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.BlogRepo;
import com.versolicitud.movieapp.service.IBlogService;

@Service
public class BlogService implements IBlogService {

	@Autowired
	private BlogRepo blogRepo;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Blog> getAll() {
		return this.blogRepo.findAll();
	}

	@Override
	public Blog getById(UUID id) {
		Optional<Blog> optional = this.blogRepo.findById(id);
		try {
			Blog blog = optional.orElseThrow(() -> new NoSuchElementException("Blog not found"));
			return blog;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Blog save(Blog blog) {
		User user = userService.getById(blog.getUser().getId());
				
		blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		blog.setUser(user);
		return this.blogRepo.save(blog);
	}

	@Override
	public void delete(UUID id) {
		this.blogRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Blog> optional = this.blogRepo.findById(id);
		try {
			Blog blog = optional.orElseThrow(() -> new NoSuchElementException("Blog not found"));
			int currentStt = blog.getStatus();
			blog.setStatus(currentStt == 1 ? 0 : 1);
			blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.blogRepo.save(blog);
		} catch (Exception e) {
			
		}
	}
	
}
