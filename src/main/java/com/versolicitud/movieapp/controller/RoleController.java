package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.List;

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

import com.versolicitud.movieapp.entity.Role;
import com.versolicitud.movieapp.service.impl.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Role>> getAllRoles() {
		try {
			return new ResponseEntity<List<Role>>(this.roleService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<Role>(this.roleService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRole(@RequestBody Role role) throws URISyntaxException {
		Role result = roleService.save(role);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable("id") Long id) throws URISyntaxException {
		this.roleService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
