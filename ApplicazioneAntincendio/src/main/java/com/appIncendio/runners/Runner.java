package com.appIncendio.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.appIncendio.entities.DispositivoFactory;
import com.appIncendio.entities.DispositivoProcess;
import com.appIncendio.entities.Sonda;
import com.appIncendio.services.ProcessService;
import com.appIncendio.services.SondaService;
import com.appIncendio.utils.TipoDispositivo;


@Component
public class Runner implements ApplicationRunner {
	
	@Autowired SondaService sondaServ;
	@Autowired ProcessService processServ;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("APPLICAZIONE RILEVAZIONE INCENDI FUNZIONANTE");

//		Sonda s = (Sonda) DispositivoFactory.createDispositivo(TipoDispositivo.SONDA);
//		s.setLatitude(15);
//		s.setLongitude(10);
//		sondaServ.saveSonda(s);
//		
//		Sonda s1 = (Sonda) DispositivoFactory.createDispositivo(TipoDispositivo.SONDA);
//		s1.setLatitude(20);
//		s1.setLongitude(10);
//		sondaServ.saveSonda(s1);
//		
//		Sonda s2 = (Sonda) DispositivoFactory.createDispositivo(TipoDispositivo.SONDA);
//		s2.setLatitude(50);
//		s2.setLongitude(25);
//		sondaServ.saveSonda(s2);
//		
//		DispositivoProcess d = new DispositivoProcess();
//		processServ.saveProcess(d);
//		DispositivoProcess d1 = new DispositivoProcess();
//		processServ.saveProcess(d1);
//		DispositivoProcess d2 = new DispositivoProcess();
//		processServ.saveProcess(d2);
		
											////////////////////
											//CHECK OBSERVABLE//
											////////////////////
		
		//associo ad 1 sonda più chiamate per esempio 
//		sondaServ.addObserver(1L, 1L);
//		sondaServ.addObserver(1L, 2L);
//		sondaServ.addObserver(1L, 3L);
		
//		seguito setto il livello di fumo tramite il check dell'observable
//		sondaServ.setSmokeLevel(5, 1L);
		
	}

}
