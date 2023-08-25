package com.versolicitud.movieapp.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
@Table(name = "users", 
uniqueConstraints = { 
  @UniqueConstraint(columnNames = "username"),
  @UniqueConstraint(columnNames = "email") 
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "username", nullable = false)
	private String username;

  	@Column(name = "email", nullable = false)
  	private String email;

  	@Column(name = "password", nullable = false)
  	private String password;
  	
	@Column(name = "first_name", nullable = false)
	private String firstName;
  	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "status", nullable = false)
	private int status;
  	
  	@Column(name = "created_at", nullable = false)
  	@CreationTimestamp
  	private Timestamp createdAt;
  	
  	@Column(name = "updated_at")
  	private Timestamp updatedAt;
  	
  	@ManyToMany(fetch = FetchType.LAZY)
  	@JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  	private Set<Role> roles = new HashSet<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<RefreshToken> tokens = new ArrayList<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Conver> convers = new ArrayList<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<ActivityHistory> actiHistories = new ArrayList<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Rep> reps = new ArrayList<>();
  	
  	@JsonIgnore
  	@OneToMany(mappedBy = "user")
    private List<Archive> archives = new ArrayList<>();
}
