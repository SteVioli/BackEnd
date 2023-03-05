package com.GestionePrenotazioni.models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "prenotazioni")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrenotazione;
	@ManyToOne
	@JoinColumn(name = "idutente")
	private Utente utente;
	
	//la richiesta era di farla valere solo un giorno, pertanto ho pensato di mettere solo la data di inizio in maniera tale che sia visibile e disponibile
	//solo nel giorno richiesto dalla prenotazione. evitando di fare check su durate, visto che esiste SOLAMENTE nella data indicata
	private LocalDate dataInizio;
	@ManyToOne
	@JoinColumn(name="idpostazione")
	private Postazione postazione;
	
	//genero un costruttore senza l id per facilitarmi la creazione del db
	public Prenotazione(Utente utente, LocalDate dataInizio, Postazione postazione) {
		super();
		this.utente = utente;
		this.dataInizio = dataInizio;
		this.postazione = postazione;
	}
	
	
	
}
