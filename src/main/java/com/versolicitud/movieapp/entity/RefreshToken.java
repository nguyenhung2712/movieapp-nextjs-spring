package com.versolicitud.movieapp.entity;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "refresh_tokens")
public class RefreshToken {
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String token;
	
	@Column(name = "expiry_date", nullable = false)
	private Instant expiryDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = true, updatable = true)
	private User user;
}
