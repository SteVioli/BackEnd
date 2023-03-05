package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.repositories.UtenteDaoRepository;

@Service
public class UtenteService  {

	@Autowired UtenteDaoRepository repo;
	
	//utilizzo un unico metodo per il save e l update perchè mantengono lo stesso metodo
	//evito duplicazione di codice
	public void saveUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente getUtentebyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Utente u) {
		repo.save(u);
	}
	
	public void deleteUtente(Utente u) {
		repo.delete(u);
	}
	
	public List<Utente> getAllUtenti() {
		return (List<Utente>) repo.findAll();
	}
	
	//metodo per popolarmi 5 utenti fittizi
	public void popolaDbUtente() {
		for (int i = 0; i < 5; i++) {
			Utente u = new Utente("Username"+i, "NomeCompleto"+i, "NomeCompleto"+i+"@example.com");
			saveUtente(u);
			System.out.println("DB utenti popolato!");
		}
	}
	
	//metodi non richiesti per fare qualche test, eventualmente richiamarlo e fare il foreach per stampare
	public List<Utente> getUtenteByEmailAndNome(String email,String nome) {
		return repo.findByEmailAndNomeCompleto(email, nome);
	}
}
