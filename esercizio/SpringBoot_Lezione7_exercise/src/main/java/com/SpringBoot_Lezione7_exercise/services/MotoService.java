package com.SpringBoot_Lezione7_exercise.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot_Lezione7_exercise.models.Moto;
import com.SpringBoot_Lezione7_exercise.repositories.MotoDaoRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class MotoService {

	@Autowired MotoDaoRepository motoRepo;
	
	
	public Moto motoSave(Moto automobile) {
		return motoRepo.save(automobile);	
	}
	
	public Moto getMotoById(Long id) {
		if(!motoRepo.existsById(id)) {
			throw new EntityExistsException("Errore Id non trovato");
		}
		return motoRepo.findById(id).get();
	}
	
	public List<Moto> getAllMoto(){
		return (List<Moto>) motoRepo.findAll();
	}
	
	public Moto motoUpdate(Moto automobile) {
		if(!motoRepo.existsById(automobile.getId())) {
			throw new EntityExistsException("Errore Id già in uso");
		}
		return motoRepo.save(automobile);	
	}
	
	public String deleteMoto(Long id) {
		if(!motoRepo.existsById(id)) {
			throw new EntityExistsException("Errore Id già in uso");
		}
		motoRepo.deleteById(id);
		return "Moto eliminata";
	}
}
