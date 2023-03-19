package com.appIncendio;

import static org.junit.Assert.*;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.appIncendio.entities.DispositivoProcess;
import com.appIncendio.entities.Sonda;
import com.appIncendio.utils.TipoDispositivo;


public class SondaTest {

	static Sonda s;
	static DispositivoProcess d;
	
	@BeforeClass
	public static void creaSondaEProcess() {
		s = new Sonda(1L, TipoDispositivo.SONDA, 15, 10, 0);
		d = new DispositivoProcess(1L, null);
	}
	

	@Test
	public void testSetSmokeLevel() {
			 Set<DispositivoProcess> set = s.getListProcesses();
			 set.add(d);
			// check list size
			 assertEquals(1,set.size());
			 System.out.println("Size del set Ok");

			 s.setSmokeLevel(5);
		        for (DispositivoProcess o : set) {
		        	o.setSmokeLevel(s.getSmokeLevel());
		        	// check smoke level
		        	assertEquals(s.getSmokeLevel(), o.getSmokeLevel());
		        	System.out.println("Livello fumo nella norma!!!!!");
		        }
		    }
	
	@AfterClass
	public static void fineTest() {
		System.out.println("Fine Tests");
	}	
	//La maggior parte della logica di questa app è sugli observer e il relativo aggiornamento per tanto mi limito a fare pochi check aggiuntivi
	//altrimenti avrei effettuato test "banali" come i vari assertEquals o notNull visti nell'esercitazione precedente
}
