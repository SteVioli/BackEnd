package com.Stefano_GestioneDispositivi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "devices")
public abstract class DispositivoAziendale {
	//ho preferito ragionare con una classe astratta e 3 classi che estendono, perchè gli enum mi sono sembrati limitanti
	//al fine di identificare una tipologia di dispositivo, perchè così se mai dovessi aggiungere o modificare proprietà, avrei
	//già le classi su cui lavorare, invece con gli enum non avrei potuto effettuare modifiche
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String azienda = "Epicode";
	protected String tipoDispositivo;
	private StatoDispositivo statoDispositivo;
}
