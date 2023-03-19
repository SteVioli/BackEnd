package com.appIncendio.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appIncendio.entities.DispositivoProcess;
import com.appIncendio.entities.Sonda;
import com.appIncendio.repositories.SondaRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class SondaService {
	
	@Autowired SondaRepository sondaRepo;
	@Autowired ProcessService processService;
	
	public Sonda saveSonda(Sonda s) {
		return sondaRepo.save(s);
	}
	
	public Sonda findSondaById(Long id) {
		if(!sondaRepo.existsById(id)) {
			throw new EntityExistsException("Error! Id not found!");
		}
		return sondaRepo.findById(id).get();
	}
	
	public List<Sonda> findAllSonda(){
		return sondaRepo.findAll();
	}
	
	public Sonda updateSonda(Sonda s) {
		if(!sondaRepo.existsById(s.getId())) {
			throw new EntityExistsException("Error! Id not found!");
		}
		return sondaRepo.save(s);
	}
	
	public void deleteSonda (Long id) {
		if(!sondaRepo.existsById(id)) {
			throw new EntityExistsException("Error! Id not found!");
		}
		sondaRepo.deleteById(id);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	//Lascio la logica all'interno del service per mantenere i file più puliti
	// Metodo affinché un observer ( process ) faccia subscribe alla sonda ( observable )
	public Set<DispositivoProcess> addObserver( Long sondaId,Long processId) {
		Sonda observable = findSondaById(sondaId);
		DispositivoProcess observer = processService.findProcessById(processId);
		observer.setSmokeLevel(observable.getSmokeLevel());
		processService.updateProcess(observer);
		observable.getListProcesses().add(observer);
        updateSonda(observable);
        return observable.getListProcesses();
    }
	
	// Metodo per aggiornare lo smokeLevel ( observable ) e far si che venga passato e aggiornato
	//ad ogni observer ( device ) 
	 public void setSmokeLevel(Integer newSmokeLevel,Long sondaId) {
		 Sonda s = findSondaById(sondaId);
		 s.setSmokeLevel(newSmokeLevel);
		 updateSonda(s);
	        for (DispositivoProcess o : s.getListProcesses()) {
	            o.update(newSmokeLevel);
	            processService.updateProcess(o);
	            if(o.update(newSmokeLevel)) {
	             System.out.println("Sonda id " + s.getId() + " rilevato livello di fumo " + s.getSmokeLevel() + "!! Inviare vigili del fuoco a latitudine " + s.getLatitude() + ", longitudine " + s.getLongitude()+ " !! - Allarme inviato da processo id " + o.getId() ); 
	            }
	            
	        }
	    }
}
