package com.SpringBoot_Lezione7_exercise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Veicolo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String marca;
	private int velocita;
	
	public Veicolo(String marca, int velocita) {
		super();
		this.marca = marca;
		this.velocita = velocita;
	}
	
	
	
}
