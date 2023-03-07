package com.SpringBoot_Lezione6_Esercizio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBoot_Lezione6_Esercizio.models.Lingua;


@Controller
public class LinguaController {
	
	@GetMapping("/home")
	public ModelAndView showForm() {
		ModelAndView model = new ModelAndView();
		return model;
	}
	
	
	@PostMapping(value = "{lingua}")
	public ModelAndView selezionaLingua(String lingua) {
		if(lingua.equals("italiano") || lingua.equals("inglese")) {
		ModelAndView model = new ModelAndView(lingua);
		return model;
		}
		throw new RuntimeException();
	}
	
	
}
