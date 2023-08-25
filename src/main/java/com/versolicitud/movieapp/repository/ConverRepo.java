package com.versolicitud.movieapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.versolicitud.movieapp.entity.Conver;

public interface ConverRepo extends JpaRepository<Conver, UUID> {

}
