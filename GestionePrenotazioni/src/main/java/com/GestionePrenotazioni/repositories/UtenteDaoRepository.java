package com.GestionePrenotazioni.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.GestionePrenotazioni.models.Utente;

@Repository
public interface UtenteDaoRepository extends CrudRepository<Utente, Long> {
	//qualche extra non richiesto
	List<Utente> findByEmailAndNomeCompleto(String email,String nome);
	List<Utente> findByUsername(String username);
}
