package com.Stefano_GestioneDispositivi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter
@ToString
public class Tablet extends DispositivoAziendale {
	
	public Tablet() {
		super.tipoDispositivo = "Tablet";
	}
}
