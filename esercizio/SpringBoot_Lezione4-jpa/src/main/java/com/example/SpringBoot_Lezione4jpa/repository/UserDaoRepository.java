package com.example.SpringBoot_Lezione4jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_Lezione4jpa.model.User;

@Repository
public interface UserDaoRepository extends CrudRepository<User, Long> {

	public List<User> findByCity(String city);
	public List<User> findByNameAndLastname(String name, String lastname);
	public List<User> findByAgeBetween(Integer min, Integer max);
	public List<User> findByAgeAndName(Integer age,String name);
}
