package com.versolicitud.movieapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versolicitud.movieapp.entity.ActivityHistory;

@Repository
public interface ActiHistoryRepo extends JpaRepository<ActivityHistory, UUID> {

}
