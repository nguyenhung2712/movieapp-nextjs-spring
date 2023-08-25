package com.versolicitud.movieapp.entity;


import com.versolicitud.movieapp.entity.combine_id.MovieActorPK;

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
@Table(name = "movie_actors")
@IdClass(MovieActorPK.class)
public class MovieActor {
	@Id
	@ManyToOne
	@JoinColumn(name = "movie_id", insertable = true, updatable = true)
	private Movie movie;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "actor", insertable = true, updatable = true)
	private Actor actor;
	
	@Column(name = "charactor_name", nullable = false)
	private String charactorName;
}