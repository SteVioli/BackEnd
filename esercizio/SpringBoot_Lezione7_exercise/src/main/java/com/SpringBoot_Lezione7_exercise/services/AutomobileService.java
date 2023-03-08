package com.SpringBoot_Lezione7_exercise.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot_Lezione7_exercise.models.Automobile;
import com.SpringBoot_Lezione7_exercise.repositories.AutomobileDaoRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class AutomobileService {

	@Autowired AutomobileDaoRepository autoRepo;
	
	public Automobile automobileSave(Automobile automobile) {
		return autoRepo.save(automobile);	
	}
	
	public Automobile findAutomobileById(Long id) {
		if(!autoRepo.existsById(id)) {
			throw new EntityExistsException();
		}
		return autoRepo.findById(id).get();
	}
	
	public List<Automobile> findAllAutomobile(){
		return (List<Automobile>) autoRepo.findAll();
	}
	
	public Automobile automobileUpdate(Automobile automobile) {
		if(!autoRepo.existsById(automobile.getId())) {
			throw new EntityExistsException();
		}
		return autoRepo.save(automobile);	
	}

	
	
	public String deleteAutomobile(Long id) {
		if(!autoRepo.existsById(id)) {
			throw new EntityExistsException();
		}
		autoRepo.deleteById(id);
		return "Automobile Eliminata";
	}
	
}
