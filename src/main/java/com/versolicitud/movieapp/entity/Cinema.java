package com.versolicitud.movieapp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cinemas")
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "latitude", nullable = false)
	@DecimalMax("180.0")
    @DecimalMin("-180.0")
    private BigDecimal latitude;
	
	@Column(name = "longtitude", nullable = false)
	@DecimalMax("180.0")
    @DecimalMin("-180.0")
    private BigDecimal longitude;
	
	@Column(name = "phone_numb", nullable = false)
	private String phoneNumb;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "updated_at", nullable = false)
  	private Timestamp updatedAt;
	
	@OneToMany(mappedBy = "cinema")
    private List<Interact> interacts = new ArrayList<>();
	
	@OneToMany(mappedBy = "cinema")
    private List<Room> rooms = new ArrayList<>();
	
	@OneToMany(mappedBy = "cinema")
    private List<Schedule> schedules = new ArrayList<>();
}
