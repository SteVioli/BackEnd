package com.GestionePrenotazioni.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;

public interface PrenotazioneDaoRepository extends CrudRepository<Prenotazione, Long> {
	
	//filtri di ricerca che mi serviranno per fare un check sulla validità o meno della prenotazione
	//vedi runner e service
	List<Prenotazione> findByDataInizioAndUtente(LocalDate dataInizio,Utente u);
	List<Prenotazione> findByDataInizioAndPostazione(LocalDate dataInizio,Postazione p);
}
