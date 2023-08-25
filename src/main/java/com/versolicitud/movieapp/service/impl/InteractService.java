package com.versolicitud.movieapp.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

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
import com.versolicitud.movieapp.service.IInteractService;

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
	public Interact getById(UUID id) {
		Optional<Interact> optional = this.interactRepo.findById(id);
		try {
			Interact interact = optional.orElseThrow(() -> new NoSuchElementException("Interaction not found"));
			return interact;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Interact save(Interact interact) {
		User user = this.userService.getById(interact.getUser().getId());
		Blog blog = this.blogService.getById(interact.getBlog().getId());
		Cinema cinema = this.cinemaService.getById(interact.getCinema().getId());
		Rep rep = this.repService.getById(interact.getRep().getId());
		Comment cmt = this.cmtService.getById(interact.getComment().getId());
		Movie movie = this.movieService.getById(interact.getMovie().getId());
		
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
		
		return this.interactRepo.save(interact);
	}

	@Override
	public void delete(UUID id) {
		this.interactRepo.deleteById(id);
	}
	
}
