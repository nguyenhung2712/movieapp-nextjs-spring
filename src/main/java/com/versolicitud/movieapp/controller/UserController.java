package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.service.impl.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        try {
            return new ResponseEntity<List<UserDTO>>(userService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<UserDTO>(userService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws URISyntaxException {
        UserDTO result = userService.save(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/toggle-status/{id}")
    public ResponseEntity<?> toggleUser(@PathVariable("id") UUID id) throws URISyntaxException {
        userService.toggleStatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id) throws URISyntaxException {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/authorize/{id}")
    public ResponseEntity<?> authorizeUser(@PathVariable("id") UUID id, @RequestBody Long[] roleIds) throws URISyntaxException {
        userService.authorizeUser(id, roleIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
