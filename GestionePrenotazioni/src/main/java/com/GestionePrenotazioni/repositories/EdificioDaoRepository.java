package com.GestionePrenotazioni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionePrenotazioni.models.Edificio;


public interface EdificioDaoRepository extends JpaRepository<Edificio, Long> {
		
	List<Edificio> findByCitta(String citta);
	
}
