package com.appIncendio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appIncendio.entities.DispositivoProcess;
import com.appIncendio.repositories.ProcessRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;

@Service
public class ProcessService {

	@Autowired ProcessRepository processRepo;
	
	public DispositivoProcess saveProcess(DispositivoProcess p) {
		return processRepo.save(p);
	}

	public DispositivoProcess findProcessById(Long id) {
		if(!processRepo.existsById(id)) {
			throw new EntityExistsException("ERRORE! Process non trovato!");
		}
		return processRepo.findById(id).get();
	}
	
	public List<DispositivoProcess> findAllProcess(){
		return processRepo.findAll();
	}
	
	public DispositivoProcess updateProcess(DispositivoProcess p) {
		if(!processRepo.existsById(p.getId())) {
			throw new EntityExistsException("ERRORE! Process non trovato! Impossibile aggiornare");
		}
		return processRepo.save(p);
	}
	
	public void deleteProcess (Long id) {
		if(!processRepo.existsById(id)) {
			throw new EntityExistsException("ERRORE! Process non trovato! Impossibile cancellare");
		}
		processRepo.deleteById(id);
	}
	

}
