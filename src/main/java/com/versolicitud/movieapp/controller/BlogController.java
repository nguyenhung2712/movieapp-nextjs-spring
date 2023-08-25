package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.service.impl.BlogService;

@RestController
@CrossOrigin
@RequestMapping("/api/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		try {
			return new ResponseEntity<List<Blog>>(this.blogService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Blog>(this.blogService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBlog(@RequestBody Blog blogDto) throws URISyntaxException {

		Blog result = this.blogService.save(blogDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleBlog(@PathVariable("id") UUID id) throws URISyntaxException {
		this.blogService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable("id") UUID id) throws URISyntaxException {
		this.blogService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
