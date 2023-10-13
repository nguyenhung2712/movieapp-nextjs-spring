package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO {
    private Long id;

    private String name;

    private Timestamp createdAt;

    private Timestamp updatedAt;

//    private Set<Role> roles = new HashSet<>();
}
