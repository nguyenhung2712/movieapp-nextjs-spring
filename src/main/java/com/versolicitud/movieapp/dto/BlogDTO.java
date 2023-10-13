package com.versolicitud.movieapp.dto;

import com.versolicitud.movieapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private UUID id;

    private String header;

    private String content;

    private int status;

    private String slug;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private UserDTO user;

//    private List<Interact> interact = new ArrayList<>();
//
//    private List<Comment> comments = new ArrayList<>();
//
//    private List<Archive> archives = new ArrayList<>();
}
