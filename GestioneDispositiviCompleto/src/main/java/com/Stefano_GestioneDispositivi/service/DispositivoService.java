package com.Stefano_GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stefano_GestioneDispositivi.models.DispositivoAziendale;
import com.Stefano_GestioneDispositivi.repository.DispositivoDaoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoService {
	
	@Autowired DispositivoDaoRepository dispositivoRepo;
	
	public DispositivoAziendale saveDispositivo(DispositivoAziendale d) {
		return dispositivoRepo.save(d);
	}
	
	public DispositivoAziendale getDispositivoById(Long id) {
		return dispositivoRepo.findById(id).get();
	}
	
	public List<DispositivoAziendale> getAllDispositivi(){
		return dispositivoRepo.findAll();
	}
	
	public String removeDispositivoById(Long id) {
		if(!dispositivoRepo.existsById(id)) {
			throw new EntityNotFoundException("Device Not Exists!!!!!!");
		}
		dispositivoRepo.deleteById(id);
		return "Dispositivo Eliminato Correttamente";
	}
}
