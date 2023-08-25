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

import com.versolicitud.movieapp.entity.Permission;
import com.versolicitud.movieapp.service.impl.PermissionService;

@RestController
@CrossOrigin
@RequestMapping("/api/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Permission>> getAllPermissions() {
		try {
			return new ResponseEntity<List<Permission>>(this.permissionService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Permission> getPermissionById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<Permission>(this.permissionService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savePermission(@RequestBody Permission permiss) throws URISyntaxException {
		Permission result = this.permissionService.save(permiss);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<?> deletePermission(@PathVariable("id") Long id) throws URISyntaxException {
		this.permissionService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
