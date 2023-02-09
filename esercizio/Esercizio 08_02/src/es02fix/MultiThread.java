package es02fix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThread implements Runnable{
	static Logger log = LoggerFactory.getLogger(MultiThread.class);

	
	
	int[] arrayElementi;
	int indiceIniziale;
	int numeroElementi;
	static List<Integer> risultati;
	
	
	public MultiThread(int[] arrayElementi, int indiceIniziale, int numeroElementi, List<Integer> risultati) {
		this.arrayElementi = arrayElementi;
		this.indiceIniziale = indiceIniziale;
		this.numeroElementi = numeroElementi;
		this.risultati = risultati;
	}
	

	@Override
	public void run() {
		
		int sommaParziale = 0;
		for (int i = indiceIniziale; i < indiceIniziale+numeroElementi; i++) {
			sommaParziale += arrayElementi[i];
		}
		
		log.info("Somma Thread: " + sommaParziale);
		risultati.add(sommaParziale);
	}
	
	
	public static  int[] popolaArray(int size) {
		Random rand = new Random();
		int[] dati = new int[size];
		for (int i = 0; i < size; i++) {
			dati[i] = rand.nextInt(11);  //valori casuali da 1 a 10 , utilizzare il nextInt()
		}
		return dati;
	}
}
