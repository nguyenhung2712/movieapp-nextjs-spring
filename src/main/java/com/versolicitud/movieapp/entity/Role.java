package com.versolicitud.movieapp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
  	
  	@Column(name = "updated_at")
  	private Timestamp updatedAt;
  	
  	@JsonIgnore
  	@ManyToMany(mappedBy="roles")
    private Set<User> users = new HashSet<>();
	
	@JsonIgnore
  	@ManyToMany(fetch = FetchType.LAZY)
  	@JoinTable(  name = "role_permiss", 
        joinColumns = @JoinColumn(name = "role_id"), 
        inverseJoinColumns = @JoinColumn(name = "permiss_id"))
  	private Set<Permission> permissions = new HashSet<>();
}
