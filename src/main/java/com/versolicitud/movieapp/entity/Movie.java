package com.versolicitud.movieapp.entity;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "director", nullable = false)
	private String director;	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "released_at", nullable = false)
  	private Timestamp releasedAt;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
  	
  	@Column(name = "updated_at")
  	private Timestamp updatedAt;
  	
  	@OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors = new ArrayList<>();
  	
  	@OneToMany(mappedBy = "movie")
    private List<Interact> interacts = new ArrayList<>();
  	
  	@OneToMany(mappedBy = "movie")
    private List<Archive> archives = new ArrayList<>();
  	
  	@OneToMany(mappedBy = "movie")
    private List<Schedule> schedules = new ArrayList<>();
  	
  	@OneToMany(mappedBy = "movie")
    private List<Episode> episodes = new ArrayList<>();
  	
  	@OneToMany(mappedBy = "movie")
    private List<Trailer> trailers = new ArrayList<>();
  	
  	@ManyToOne
	@JoinColumn(name = "genre_id", insertable = true, updatable = true)
	private Genre genre;
}
