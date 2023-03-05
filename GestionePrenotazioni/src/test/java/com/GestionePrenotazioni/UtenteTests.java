package com.GestionePrenotazioni;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.GestionePrenotazioni.models.Prenotazione;
import com.GestionePrenotazioni.models.Utente;
import com.GestionePrenotazioni.services.UtenteService;


public class UtenteTests {
	static Utente u;
	static List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();
	@Autowired UtenteService utenteService;
	
	@BeforeClass
	public static void beforeUtente() {
		u = new Utente();
		u.setIdUtente(1l);
		u.setEmail("test@test.it");
		u.setNomeCompleto("NomeTest");
		u.setUsername("UsernameTest");
		u.setPrenotazione(listaPrenotazioni);
	}
	
	@Test
	public void testVerificaNomeUtente() {
		assertEquals("NomeTest", u.getNomeCompleto());
		System.out.println("Nome Utente corrispondente a " + u.getNomeCompleto());
	}
	
	@Test
	public void testVerificaUsernameUtente() {
		assertEquals("UsernameTest", u.getUsername());
		System.out.println("Username corrispondente a " + u.getUsername());
	}
	
	@Test
	public void testVerificaEmailUtente() {
		assertEquals("test@test.it", u.getEmail());
		System.out.println("Email corrispondente a " + u.getEmail());
	}
	@Test
	public void testVerificaListaPrenotazioneUtente() {
		assertNotNull(listaPrenotazioni);
		System.out.println("Lista Prenotazioni esistente!");
	}
	
	
	@After
	public void afterTest() {
		System.out.println("@After - Fine Test!");
	}
	
	@AfterClass
	public static void fine() {
		System.out.println("CHIUSURA TESTS!!!!!");
	}
}
