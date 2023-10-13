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
@Table(name = "trailers")
public class Trailer {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "url")
	private String url;	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "updated_at", nullable = false)
  	private Timestamp updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", insertable = true, updatable = true)
	private Movie movie;
}
