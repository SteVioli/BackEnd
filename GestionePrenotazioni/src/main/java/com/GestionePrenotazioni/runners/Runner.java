package com.GestionePrenotazioni.runners;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.services.EdificioService;
import com.GestionePrenotazioni.services.PostazioneService;
import com.GestionePrenotazioni.services.PrenotazioneService;
import com.GestionePrenotazioni.services.UtenteService;

@Component
public class Runner implements ApplicationRunner {
	
	//importo i vari service per lanciare i vari crud e metodi di check sul db
	@Autowired UtenteService utenteService;
	@Autowired EdificioService edificioService;
	@Autowired PostazioneService postazioneService;
	@Autowired PrenotazioneService prenotazioneService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("runner");
		
		//commentare e decommentare i metodi di popolamento generici e random
		
//		utenteService.popolaDbUtente();
//		edificioService.popolaDbEdificio();
//		postazioneService.popolaDbPostazione();
		
		//le prenotazioni le creo singole per utilizzare anche i metodi di find
		//e farle più specifiche, visto che sono richiesti i maggiori controlli e test
		
//		
		//CREAZIONE PRENOTAZIONE SINGOLA
		
//		Prenotazione p = new Prenotazione();
//		p.setDataInizio(LocalDate.of(2023, 2, 15));
//		List<Utente> listaUtenti = utenteService.getAllUtenti();
//		p.setUtente(listaUtenti.get(1));
//		List<Postazione> listaPostazioni = postazioneService.getAllPostazioni();
//		p.setPostazione(listaPostazioni.get(1));
//		prenotazioneService.savePrenotazione(p);
		
		
		
		//CREAZIONE CON CHECK PRENOTAZIONE -> NOT ALLOWED IF THE SAME USER BOOK FOR THE SAME DATE!!!
		//Fare check con gli stessi dati (Utente e Date) di una prenotazione già esistente, inoltre fa un check se è occupata o meno e cambia lo stato eventualmente
//		
		
		//COMMENTARE E DECOMMENTARE 
		
//		Prenotazione p = new Prenotazione();
//		p.setDataInizio(LocalDate.of(2023, 2, 15));
//		List<Utente> listaUtenti = utenteService.getAllUtenti();
//		p.setUtente(listaUtenti.get(1));
//		List<Postazione> listaPostazioni = postazioneService.getAllPostazioni();
//		p.setPostazione(listaPostazioni.get(1));
//		prenotazioneService.savePrenotazione(p);
//////////////////////////////////////////////////////////////////////////////////		
		
//////////////////////////////////////////////////////////////////////////////////
		//COMMENTARE E DECOMMENTARE 
		
		//CHECK VALIDITA PRENOTAZIONI
		//Ho fatto questo controllo con la seguente logica:
		//1- dichiaro una nuova prenotazione (dati indifferenti, l importante per fare il check veloce è rilanciarla 2 volte di seguito, così da generare l'errore
		Prenotazione p = new Prenotazione(utenteService.getUtentebyId(2L), LocalDate.of(2023, 05, 01),
              postazioneService.getPostazionebyId(3L));
     
		//2- condizione per vedere se la lista di prenotazione con i parametri da me inseriti esiste, allora non posso effettuarla
		// visto che si è deciso che l utente non possa avere la possibilità di creare una prenotazione per la stessa data
      if(prenotazioneService.getByDataAndUtente(p.getDataInizio(), p.getUtente()).size()>0) {
          System.out.println("PRENOTAZIONE NON RIUSCITA!!! L'utente: " + p.getUtente().getNomeCompleto() + " ha già effettuato una prenotazione per la data: " + p.getDataInizio());
      }else {
        
    	  //3- stesso ragionamento del punto 2 solo che effettuo un check in un secondo momento, verificando l esistenza della lista con la postazione
    	  //in una data precisa. ovvero non posso prenotare una postazione specifica in una determinata data se questa già esiste
    	  //risulta di fatto occupata. così mi sono risparmiato il parametro booleano. altrimenti avrei anche fatto passaggi in più dove verificavo
    	  //se il booleano era true o false e di conseguenza avrei dovuto settarlo in un secondo momento se la prenotazione avveniva
          if(prenotazioneService.getByDataAndPostazione(p.getDataInizio(), p.getPostazione()).size() >0) {
              System.out.println("PRENOTAZIONE NON RIUSCITA!!! La postazione: " + p.getPostazione().getDescription() + " è già stata assegnata per la data: " + p.getDataInizio());
          }else {
        	  
        	  //4- se non c'è nessuna condizione da me dichiarata prima, vuol dire che:
        	  //posso far PRENOTARE in una DETERMINATA DATA una DETERMINATA POSTAZIONE per un DETERMINATO UTENTE
              prenotazioneService.savePrenotazione(p);
              System.out.println("Prenotazione avvenuta correttamente per l'utente: " + p.getUtente().getNomeCompleto() + " per la postazione " + p.getPostazione().getDescription() + " in data: " + p.getDataInizio());
          }
      }
		
		
		//REPOSITORY E SERVICE
		
		//RICERCHE - FIND
        
//      List<Prenotazione> listaPrenotazioni = prenotazioneService.getAllPrenotazioni();
//		listaPrenotazioni.forEach(p-> System.out.println("Prenotazione id: " + p.getIdPrenotazione()));
		
//		List<Postazione> listaPostazioni = postazioneService.getTipo(Tipo.SALA_RIUNIONI);		
//		listaPostazioni.forEach(p -> System.out.println("Postazione trovata: " + p.getDescription() +" con numero massimo occupanti: "+ p.getNumMaxOccupanti()));
		
//		List<Edificio> listaEdificio = edificioService.getByCity("Città0");
//		listaEdificio.forEach(e-> System.out.println(e));
		
//		List<Postazione> listaPostazioni2 = postazioneService.cercaTipoAndCitta(Tipo.SALA_RIUNIONI, "Città2");
//		listaPostazioni2.forEach(p->System.out.println(p.getNumMaxOccupanti()));
		
		
	}
	
}
