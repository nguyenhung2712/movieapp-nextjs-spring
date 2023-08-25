package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
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

import com.versolicitud.movieapp.entity.Comment;
import com.versolicitud.movieapp.service.impl.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	private CommentService cmtService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<Comment>(cmtService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveComment(@RequestBody Comment cmt) throws URISyntaxException {
		Comment result = this.cmtService.save(cmt);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleComment(@PathVariable("id") UUID id) throws URISyntaxException {
		this.cmtService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") UUID id) throws URISyntaxException {
		this.cmtService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
