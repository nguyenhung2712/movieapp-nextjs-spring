package com.versolicitud.movieapp.dto;

import com.versolicitud.movieapp.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private int status;

    private int is2FA;

    private int isActivated;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Set<Role> roles = new HashSet<>();

    private List<Message> messages = new ArrayList<>();

    private List<RefreshToken> tokens = new ArrayList<>();

    private List<ConverDTO> convers = new ArrayList<>();

    private List<ActivityHistory> actiHistories = new ArrayList<>();

    private List<Booking> bookings = new ArrayList<>();

    private List<Blog> blogs = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    private List<Rep> reps = new ArrayList<>();

    private List<Archive> archives = new ArrayList<>();
}
