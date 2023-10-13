package com.versolicitud.movieapp.dto;

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
public class RepDTO {
    private UUID id;

    private String message;

    private String images;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private UserDTO user;

    private CommentDTO comment;

//    private List<Interact> interacts = new ArrayList<>();
}
