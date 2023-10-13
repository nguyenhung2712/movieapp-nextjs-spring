package com.versolicitud.movieapp.dto;

import com.versolicitud.movieapp.entity.Interact;
import com.versolicitud.movieapp.entity.Room;
import com.versolicitud.movieapp.entity.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {
    private UUID id;

    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String phoneNumb;

    private int status;

    private Timestamp createdAt;

    private Timestamp updatedAt;

//    private List<Interact> interacts = new ArrayList<>();
//
//    private List<Room> rooms = new ArrayList<>();
//
//    private List<Schedule> schedules = new ArrayList<>();
}
