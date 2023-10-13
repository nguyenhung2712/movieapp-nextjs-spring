package com.versolicitud.movieapp.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.Trailer;
import com.versolicitud.movieapp.service.impl.TrailerService;

@RestController
@CrossOrigin
@RequestMapping("/api/trailer")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @GetMapping("/all")
    public ResponseEntity<List<Trailer>> getAllTrailers() {
        try {
            return new ResponseEntity<List<Trailer>>(this.trailerService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trailer> getTrailerById(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<Trailer>(this.trailerService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveTrailer(@RequestBody Trailer trailer) throws URISyntaxException {
        Trailer result = this.trailerService.save(trailer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrailer(@PathVariable("id") UUID id) throws URISyntaxException {
        this.trailerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
