package com.SpringBoot_Lezione7_exercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot_Lezione7_exercise.models.Moto;
import com.SpringBoot_Lezione7_exercise.services.MotoService;

@RestController
@RequestMapping("/autosalone")
public class MotoController {
	
	@Autowired MotoService motoService;

	@GetMapping("/moto/{id}")
	public ResponseEntity<Moto> getMotoById(@PathVariable Long id){
		return new ResponseEntity<Moto>(motoService.getMotoById(id),HttpStatus.OK);	
	}
	
	@GetMapping("/moto")
	public ResponseEntity<List<Moto>> getMotoById(){
		return new ResponseEntity<List<Moto>>(motoService.getAllMoto(),HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Moto> addMoto(@RequestBody Moto moto){
		return new ResponseEntity<Moto>(motoService.motoSave(moto),HttpStatus.OK);
	}
	
	@PutMapping("/moto/{id}")
	public ResponseEntity<Moto> updateMoto(@RequestBody Moto moto){
		return new ResponseEntity<Moto>(motoService.motoUpdate(moto), HttpStatus.OK);
	}
	
	@DeleteMapping("/moto/{id}")
	public ResponseEntity<String> deleteMoto (@PathVariable Long id) {
		return new ResponseEntity<String>(motoService.deleteMoto(id), HttpStatus.OK);
	}
}
