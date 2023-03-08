package com.SpringBoot_Lezione7_exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot_Lezione7_exercise.models.Moto;
import com.SpringBoot_Lezione7_exercise.repositories.MotoPageRepository;


@RestController
@RequestMapping("autosalone/pageable")
public class MotoPageableController {
	
	@Autowired MotoPageRepository motoPageRepo;
	
	@GetMapping
	public ResponseEntity<Page<Moto>> getPageableMotos(Pageable pageable){
		return new ResponseEntity<Page<Moto>>(motoPageRepo.findAll(pageable),HttpStatus.OK);
	}
	
}
