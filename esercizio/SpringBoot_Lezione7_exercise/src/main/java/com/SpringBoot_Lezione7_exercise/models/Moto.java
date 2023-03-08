package com.SpringBoot_Lezione7_exercise.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto extends Veicolo {

	private String casco;

	public Moto( String marca, int velocita, String casco ) {
		super(marca, velocita);
		this.casco = casco;
		
	}


	
}
