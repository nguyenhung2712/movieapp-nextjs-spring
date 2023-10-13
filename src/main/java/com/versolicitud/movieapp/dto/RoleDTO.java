package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long id;

    private String name;

    private Timestamp createdAt;

    private Timestamp updatedAt;

//    private Set<User> users = new HashSet<>();
//
//    private Set<Permission> permissions = new HashSet<>();
}
