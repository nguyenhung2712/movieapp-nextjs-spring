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
@Table(name = "seats")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;
	
	@Column(name = "row_numb", nullable = false)
	private int rowNumb;	
	
	@Column(name = "col_numb", nullable = false)
	private int colNumb;	
	
	@Column(name = "seat_numb", nullable = false)
	private int seatNumb;
	
	@Column(name = "status", nullable = false)
	private int status;
  	
  	@Column(name = "created_at", nullable = false)
  	@CreationTimestamp
  	private Timestamp createdAt;
  	
  	@Column(name = "updated_at")
  	private Timestamp updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "room_id", insertable = true, updatable = true)
	private Room room;
	
	@OneToMany(mappedBy = "seat")
    private List<Ticket> tickets = new ArrayList<>();
}
