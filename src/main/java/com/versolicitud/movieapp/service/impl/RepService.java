package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Comment;
import com.versolicitud.movieapp.entity.Rep;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.RepRepo;
import com.versolicitud.movieapp.service.IRepService;

@Service
public class RepService implements IRepService {

	@Autowired
	private RepRepo repRepo;
	
	@Autowired
	private CommentService cmtService;

	@Autowired
	private UserService userService;
	
	@Override
	public Rep getById(UUID id) {
		Optional<Rep> optional = this.repRepo.findById(id);
		try {
			Rep rep = optional.orElseThrow(() -> new NoSuchElementException("Comment Reply not found"));
			return rep;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Rep save(Rep rep) {
		Comment cmt = this.cmtService.getById(rep.getComment().getId());
		User user = this.userService.getById(rep.getUser().getId());
		
		rep.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		rep.setUser(user);
		rep.setComment(cmt);
		
		return this.repRepo.save(rep);
	}

	@Override
	public void delete(UUID id) {
		this.repRepo.deleteById(id);
	}

	@Override
	public void toggleStatus(UUID id) {
		Optional<Rep> optional = this.repRepo.findById(id);
		try {
			Rep rep = optional.orElseThrow(() -> new NoSuchElementException("Comment Reply not found"));
			int currentStt = rep.getStatus();
			rep.setStatus(currentStt == 1 ? 0 : 1);
			rep.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			this.repRepo.save(rep);
		} catch (Exception e) {
			
		}
	}
	
}
