package com.example.SpringBoot_Lezione4jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Lezione4jpa.model.User;
import com.example.SpringBoot_Lezione4jpa.repository.UserDaoRepository;

@Service
public class UserService {
	
	@Autowired UserDaoRepository repo;
	
	public void insertUser(User user) {
		repo.save(user);
	}
	
	public User getUserByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updateUser(User user) {
		repo.save(user);
	}
	
	public void removeUser(User user) {
		repo.delete(user);
	}
	
	public List<User> getAllUser() {
		return (List<User>) repo.findAll();
	}
	
	public List<User> getAgeBetween(Integer min, Integer max) {
		return repo.findByAgeBetween(min, max);
	}
	
	public List<User> getAgeAndName(Integer age,String name){
		return repo.findByAgeAndName(age,name);
	}

}
