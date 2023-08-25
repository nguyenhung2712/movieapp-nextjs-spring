package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.Collection;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.service.impl.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
		    String username = authentication.getName();
		    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		    
		    return new ResponseEntity<>(authentication, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User is not authenticated", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<List<User>>(this.userService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") UUID id) {
		try {
			return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) throws URISyntaxException {
//		RoleDTO role = this.roleService.getById(userDto.getRole().getId());
//		
//		userDto.setRole(role);	
		
		User result = userService.save(user);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/toggle-status/{id}")
	public ResponseEntity<?> toggleUser(@PathVariable("id") UUID id) throws URISyntaxException {
		this.userService.toggleStatus(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id) throws URISyntaxException {
		this.userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
