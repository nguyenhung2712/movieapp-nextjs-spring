package com.versolicitud.movieapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versolicitud.movieapp.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, UUID> {

}
