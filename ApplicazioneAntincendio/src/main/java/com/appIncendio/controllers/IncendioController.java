package com.appIncendio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appIncendio.entities.Sonda;
import com.appIncendio.repositories.SondaRepository;
import com.appIncendio.services.ProcessService;
import com.appIncendio.services.SondaService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/controllo")
public class IncendioController {
	@Autowired SondaRepository sondaRepo;
	@Autowired SondaService sondaServ;
	@Autowired ProcessService procServ;
	
	
	//nel controller lascio solo il get, perchè voglio che il sito sia solo di VISUALIZZAZIONE e non
	//voglio che sia possibile apportare alcuna modifica ai dati, visto che vengono aggiornati lato server
	//se avessi voluto effetturare modifiche, avrei creato dei ruoli di amministrazione per effettuare queste modifiche
	//trovo proprio sbagliato lasciare la possibilità di poter interagire a dati importanti altrimenti
	
	@GetMapping("/sonde")
	public ResponseEntity<List<Sonda>> visualizzaIncendi() {
		if(sondaServ.findAllSonda() != null) {
		return new ResponseEntity<List<Sonda>> (sondaServ.findAllSonda(),HttpStatus.OK);
		}
		throw new EntityExistsException("Sonde non disponibili");
	}
	
	@GetMapping("/allarme/{id}")
	public String visualizzaSondeOperative(@PathVariable Long id){
		if(!sondaRepo.existsById(id)) {
			throw new EntityNotFoundException("Errore! Sonda non trovata ");
		}
		Sonda s = sondaServ.findSondaById(id);
		return "Sonda visualizzata: -id " + s.getId() 
		+ " -latitudine: " + s.getLatitude() 
		+ " -longitudine: " + s.getLongitude()
		+ " -LIVELLO FUMO: " + s.getSmokeLevel();
	}

}
