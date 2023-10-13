package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private UUID id;

    private String text;

    private String images;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private UserDTO user;

    private ConverDTO conver;
}
