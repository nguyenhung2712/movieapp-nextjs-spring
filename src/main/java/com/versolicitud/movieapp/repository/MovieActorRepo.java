package com.versolicitud.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versolicitud.movieapp.entity.MovieActor;
import com.versolicitud.movieapp.entity.combine_id.MovieActorPK;

@Repository
public interface MovieActorRepo extends JpaRepository<MovieActor, MovieActorPK> {

}
