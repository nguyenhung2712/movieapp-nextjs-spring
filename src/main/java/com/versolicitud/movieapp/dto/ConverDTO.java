package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConverDTO {
    private UUID id;

    private String name;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private UserDTO user;

//    private List<Message> messages = new ArrayList<>();
}
