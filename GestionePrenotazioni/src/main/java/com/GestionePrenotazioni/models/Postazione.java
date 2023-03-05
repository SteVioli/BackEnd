package com.GestionePrenotazioni.models;

import java.util.List;

import com.GestionePrenotazioni.enums.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostazione;
	private String description;
	private int numMaxOccupanti;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	//utilizzo un booleano visto che può essere libera o occupata
	//quindi come valore di riferimento uso true o false
	private boolean occupata = false;
	
	@ManyToOne
	@JoinColumn(name = "idedificio")
	private Edificio edificio;
	
	@OneToMany(mappedBy = "postazione")
	private List<Prenotazione> prenotazione;
	//dichiaro costruttore senza id per facilitarmi la creazione del db
	public Postazione(String description, int numMaxOccupanti, Tipo tipo,Edificio edificio) {
		super();
		this.description = description;
		this.numMaxOccupanti = numMaxOccupanti;
		this.tipo = tipo;
		this.edificio = edificio;
	}
	
	
}
