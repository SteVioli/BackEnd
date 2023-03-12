package com.Stefano_GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stefano_GestioneDispositivi.models.User;
import com.Stefano_GestioneDispositivi.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired UserRepository userRepo;
	
	public User updateUser(User u) {
		userRepo.save(u);
		return u;
	}
	
	public List<User> getAllUsers(){
		return (List<User>) userRepo.findAll();
	}
	
	public <Optional>User getUserById(Long id) {
		if(!userRepo.existsById(id)) {
			throw new EntityNotFoundException("L'utente non esiste!!!!!!");
		}
		return userRepo.findById(id).get();
	}
	
	public String removeUserById(Long id) {
		if(!userRepo.existsById(id)) {
			throw new EntityNotFoundException("User Not Exists!!!!!!");
		}
		userRepo.deleteById(id);
		return "User Eliminato Correttamente";
	}
}
