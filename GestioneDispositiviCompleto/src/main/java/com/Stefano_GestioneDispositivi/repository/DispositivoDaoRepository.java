package com.Stefano_GestioneDispositivi.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Stefano_GestioneDispositivi.models.DispositivoAziendale;

public interface DispositivoDaoRepository extends JpaRepository<DispositivoAziendale, Long> {
	
	
}
