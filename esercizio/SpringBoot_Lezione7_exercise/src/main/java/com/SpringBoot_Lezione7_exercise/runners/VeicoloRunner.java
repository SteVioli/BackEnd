package com.SpringBoot_Lezione7_exercise.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot_Lezione7_exercise.models.Moto;
import com.SpringBoot_Lezione7_exercise.services.MotoService;

@Component
public class VeicoloRunner implements ApplicationRunner {
	@Autowired MotoService motoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Gavioli è fortissimo");
		
	}

}
