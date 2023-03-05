package com.GestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.repositories.EdificioDaoRepository;

@Service
public class EdificioService {

	@Autowired EdificioDaoRepository repo;
	
	
	//utilizzo un unico metodo per il save e l update perchè mantengono lo stesso metodo
	//evito duplicazione di codice
	public void saveEdificio(Edificio e) {
		repo.save(e);
	}
	
	public Edificio getEdificiobyId(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteEdificio(Edificio e) {
		repo.delete(e);
	}
	
	public List<Edificio> getAllEdifici() {
		return (List<Edificio>) repo.findAll();
	}
	
	public void popolaDbEdificio() {
		for (int i = 0; i < 5; i++) {
			Edificio e = new Edificio("Ufficio"+i, "Indirizzo"+i,"Città"+i );
			repo.save(e);
			System.out.println("DB edifici popolato!");
		}
	}
	
	public List<Edificio> getByCity(String city){
		return repo.findByCitta(city);
	}
}
