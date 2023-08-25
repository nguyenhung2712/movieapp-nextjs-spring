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
@Table(name = "archives")
public class Archive {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "type", nullable = false)
	private int type;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
  	
  	@Column(name = "updated_at")
  	private Timestamp updatedAt;
  	
  	@ManyToOne
	@JoinColumn(name = "user_id", insertable = true, updatable = true)
	private User user;
  	
  	@ManyToOne
	@JoinColumn(name = "blog_id", insertable = true, updatable = true)
	private Blog blog;
  	
  	@ManyToOne
	@JoinColumn(name = "movie_id", insertable = true, updatable = true)
	private Movie movie;
}
