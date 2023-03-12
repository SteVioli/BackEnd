package com.Stefano_GestioneDispositivi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter
@ToString
public class Laptop extends DispositivoAziendale {
	public Laptop() {
		super.tipoDispositivo = "Laptop";
	}
	
}
