package com.versolicitud.movieapp.entity.combine_id;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MovieActorPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private UUID movie;
    private UUID actor;
    
}
