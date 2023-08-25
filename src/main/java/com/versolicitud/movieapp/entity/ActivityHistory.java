package com.versolicitud.movieapp.entity;

import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "acti_histories")
public class ActivityHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "title", nullable = false)
	private String title;

  	@Column(name = "browser")
  	private String browser;
  	
  	@Column(name = "device")
  	private String device;
  	
  	@Column(name = "created_at", nullable = false)
  	@CreationTimestamp
  	private Timestamp createdAt;
  	
  	@ManyToOne
	@JoinColumn(name = "user_id", insertable = true, updatable = true)
	private User user;
}
