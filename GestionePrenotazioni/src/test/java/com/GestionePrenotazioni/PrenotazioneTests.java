package com.GestionePrenotazioni;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Edificio;
import com.GestionePrenotazioni.models.Postazione;
import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;

public class PrenotazioneTests {
	
	static List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();
	static Prenotazione p;
	@BeforeClass
	public static void creaUnaPrenotazioneFittizia() {
		
		p = new Prenotazione(new Utente("Username", "nomeCompleto", "email"),LocalDate.of(2023, 02, 02), 
				new Postazione("Descrizione", 8, Tipo.OPENSPACE, new Edificio("NomeEdificio", "IndirizzoEdificio", "CittàEdificio")));
		listaPrenotazioni.add(p);
		System.out.println("Aggiunto 1 prenotazione");
	}
	
	@Test //test con esito positivo. stessa logica anche se passassi utente! IT WORKS!!
	public void checkNOTCreazionePrenotazione() {
		Prenotazione p1 = new Prenotazione();
		Postazione pos = new Postazione("Descrizione", 8, Tipo.OPENSPACE, new Edificio("NomeEdificio", "IndirizzoEdificio", "CittàEdificio"));
		p1.setDataInizio(LocalDate.of(2023, 02, 02));
		p1.setPostazione(pos);
		
		if(p1.getDataInizio().equals(p.getDataInizio())&& p1.getPostazione().getEdificio().getCitta().equals(p.getPostazione().getEdificio().getCitta())) {
			System.out.println("NON PUOI PRENOTARE. STESSA DATA PER LA STESSA POSTAZIONE!!!!!");
		}else {
			System.out.println("PRENOTAZIONE CONFERMATA!!!");
		}
	}

}
