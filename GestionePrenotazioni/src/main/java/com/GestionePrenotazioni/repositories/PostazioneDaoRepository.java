package com.GestionePrenotazioni.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.enums.Tipo;
import com.GestionePrenotazioni.models.Postazione;

public interface PostazioneDaoRepository extends CrudRepository<Postazione, Long>{
			
		public List<Postazione> findByTipo(Tipo tipo);
		
}
