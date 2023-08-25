package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.Comment;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.CommentRepo;
import com.versolicitud.movieapp.service.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private CommentRepo cmtRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;

	@Override
	public Comment getById(UUID id) {
		Optional<Comment> optional = this.cmtRepo.findById(id);
		try {
			Comment cmt = optional.orElseThrow(() -> new NoSuchElementException("Comment not found"));
			return cmt;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Comment save(Comment cmt) {
		User user = this.userService.getById(cmt.getUser().getId());
		Blog blog = this.blogService.getById(cmt.getBlog().getId());
		
		cmt.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		cmt.setUser(user);
		cmt.setBlog(blog);
		
		return this.cmtRepo.save(cmt);
	}

	@Override
	public void delete(UUID id) {
		this.cmtRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Comment> optional = this.cmtRepo.findById(id);
		try {
			Comment cmt = optional.orElseThrow(() -> new NoSuchElementException("Comment not found"));
			int currentStt = cmt.getStatus();
			cmt.setStatus(currentStt == 1 ? 0 : 1);
			cmt.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.cmtRepo.save(cmt);
		} catch (Exception e) {
			
		}
	}
	
}
