package es02fix;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainFixProject {

	static Logger log = LoggerFactory.getLogger(MultiThread.class);
	public static void main(String[] args) {
	int[] elementi = MultiThread.popolaArray(3000);
		
		List<Integer> listaRisultati = new ArrayList<Integer>();
		MultiThread m1 = new MultiThread(elementi, 0, 1000, listaRisultati);
		MultiThread m2 = new MultiThread(elementi, 1000, 1000, listaRisultati);
		MultiThread m3 = new MultiThread(elementi, 2000, 1000, listaRisultati);

		Thread t1 = new Thread(m1);		
		Thread t2 = new Thread(m2);		
		Thread t3 = new Thread(m3);		

		t1.start(); //PARTONO TUTTI ASSIEME
		t2.start();
		t3.start();
		
		try {
			t1.join(); //PRIMA DI ANDARE AVANTI MI ACCERTO CHE TUTTI E 3 ABBIANO FINITO
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		
		int sommaTotale = 0;
		for (Integer val : listaRisultati) {
			sommaTotale += val;
		}
		
		log.info("Somma Totale: " + sommaTotale);

	}

}
