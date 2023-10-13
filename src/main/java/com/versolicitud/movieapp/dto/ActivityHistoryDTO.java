package com.versolicitud.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityHistoryDTO {
    private UUID id;

    private String title;

    private String browser;

    private String device;

    private Timestamp createdAt;

    private UserDTO user;
}
