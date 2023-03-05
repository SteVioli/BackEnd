package com.GestionePrenotazioni.services;


import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.repositories.PrenotazioneDaoRepository;

@Service
public class PrenotazioneService {

@Autowired PrenotazioneDaoRepository repo;
@Autowired PostazioneService posSrv;

	
	//utilizzo un unico metodo per il save e l update perchè mantengono lo stesso metodo
	//evito duplicazione di codice
	public void savePrenotazione(Prenotazione p) {
		repo.save(p);
		System.out.println("Prenotazione creata!");
	}
	
	public Prenotazione getPrenotazionebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void deletePrenotazione(Prenotazione p) {
		repo.delete(p);
	}
	
	public List<Prenotazione> getAllPrenotazioni() {
		return (List<Prenotazione>) repo.findAll();
	}
	
	public List<Prenotazione> getByDataAndUtente(LocalDate d,Utente u){
		return repo.findByDataInizioAndUtente(d, u);
	}
	
	public List<Prenotazione> getByDataAndPostazione(LocalDate d,Postazione p){
		return repo.findByDataInizioAndPostazione(d, p);
	}
	
}
