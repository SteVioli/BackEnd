package com.Stefano_GestioneDispositivi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter
@ToString
public class Smartphone extends DispositivoAziendale {
	
	public Smartphone() {
		super.tipoDispositivo = "Smartphone";
	}
	
}
