package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Archive;
import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.Movie;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.ArchiveRepo;
import com.versolicitud.movieapp.service.IArchiveService;

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
	public List<Archive> getAll() {
		return this.archiveRepo.findAll();
	}

	@Override
	public Archive getById(UUID id) {
		Optional<Archive> optional = this.archiveRepo.findById(id);
		try {
			Archive archive = optional.orElseThrow(() -> new NoSuchElementException("Archive not found"));
			return archive;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Archive save(Archive archive) {
		Blog blog = this.blogService.getById(archive.getBlog().getId());
		User user = this.userService.getById(archive.getBlog().getId());
		Movie movie = this.movieService.getById(archive.getBlog().getId());
		
		archive.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		archive.setBlog(blog);
		archive.setUser(user);
		archive.setMovie(movie);
		
		return this.archiveRepo.save(archive);
	}

	@Override
	public void delete(UUID id) {
		this.archiveRepo.deleteById(id);
	}
	
}
