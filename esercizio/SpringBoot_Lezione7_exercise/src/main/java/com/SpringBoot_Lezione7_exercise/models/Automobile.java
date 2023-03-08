package com.SpringBoot_Lezione7_exercise.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Automobile extends Veicolo {
	
	private boolean ariaCondizionata;

}
