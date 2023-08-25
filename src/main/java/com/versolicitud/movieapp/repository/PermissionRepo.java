package com.versolicitud.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versolicitud.movieapp.entity.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {

}
