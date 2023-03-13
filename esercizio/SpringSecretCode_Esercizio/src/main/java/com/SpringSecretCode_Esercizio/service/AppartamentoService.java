package com.SpringSecretCode_Esercizio.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringSecretCode_Esercizio.entity.Appartamento;
import com.SpringSecretCode_Esercizio.repository.AppartamentoRepository;

@Service
public class AppartamentoService {
	@Autowired AppartamentoRepository appRepo;
	
	public String addAppartamento(Appartamento a) {
		appRepo.save(a);
		return "Appartamento: " + a;
	}
	
	public Appartamento findAppartamentoById(Long id) {
		Appartamento a	=  appRepo.findById(id).get();
		return a;
	}
}
