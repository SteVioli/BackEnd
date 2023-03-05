package com.GestionePrenotazioni.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.repositories.PostazioneDaoRepository;

@Service
public class PostazioneService {

//metto l autowired al service di eficio per popolarmi in maniera automatica le postazioni
@Autowired EdificioService edServ;
@Autowired PostazioneDaoRepository repo;

	
	//utilizzo un unico metodo per il save e l update perchè mantengono lo stesso metodo
	//evito duplicazione di codice
	public void savePostazione(Postazione p) {
		repo.save(p);
	}
	
	public Postazione getPostazionebyId(Long id) {
		return repo.findById(id).get();
	}
	
	
	public void deletePostazione(Postazione p) {
		repo.delete(p);
	}
	
	public List<Postazione> getAllPostazioni() {
		return (List<Postazione>) repo.findAll();
	}
	
	public void popolaDbPostazione() {
		List<Edificio> listaEdifici = edServ.getAllEdifici();
		Postazione p = new Postazione("Postazione 1", 5, Tipo.PRIVATO, listaEdifici.get(1));
		Postazione p1 = new Postazione("Postazione 2", 7, Tipo.SALA_RIUNIONI,listaEdifici.get(2));
		Postazione p2 = new Postazione("Postazione 3", 2 ,Tipo.PRIVATO, listaEdifici.get(2));
		Postazione p3 = new Postazione("Postazione 4", 10, Tipo.SALA_RIUNIONI, listaEdifici.get(1));
		Postazione p4 = new Postazione("Postazione 5", 8, Tipo.OPENSPACE, listaEdifici.get(4));
		
		savePostazione(p);savePostazione(p1);savePostazione(p2);savePostazione(p3);savePostazione(p4);
		
		
		System.out.println("DB Postazioni popolato!!");
	}
	
	public List<Postazione> getTipo(Tipo tipo){
		return repo.findByTipo(tipo);
	}
	
	public List<Postazione> cercaTipoAndCitta(Tipo tipo,String citta){
		//dichiaro 1 lista filtrata per il tipo da me richiesto che passo come parametro
	     List<Postazione> listaPostazione = repo.findByTipo(tipo);
	     
	   //dichiaro una nuova lista vuota che andrò a riempire con tutti gli elementi trovati dopo la ricerca e i vari filtri e condizioni
	     List<Postazione> nuovaListaPostazione = new ArrayList<Postazione>();
	     
	     //itero la mia lista filtrata andando a selezionare solo quegli elementi che in questo caso abbiano il valore città come dal parametro da me impostato
	        for(int i = 0; i<listaPostazione.size();i++) {
	            if(listaPostazione.get(i).getEdificio().getCitta().equals(citta)) {
	            	
	            	//aggiungo il mio elemento alla mia nuova lista vuota
	            	nuovaListaPostazione.add(listaPostazione.get(i));
	            }
	        }
	        //mi faccio ritornare la mia nuova lista che conterrà solo gli elementi con le caratteristiche da me interessate
	        return nuovaListaPostazione;
	    }
	
}
