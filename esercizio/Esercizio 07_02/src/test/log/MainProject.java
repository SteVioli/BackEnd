package test.log;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	static	Logger log = LoggerFactory.getLogger(MainProject.class);
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		esSet();
		
	}

	//ESERCIZIO 1
	public static void esSet() {
		Set<String> s = new HashSet<String>();
		System.out.println("Quante parole vuoi inserire?");
		try {
			int numeroParole = Integer.parseInt(sc.nextLine());
			int[] array = new int[numeroParole];
			for(int i = 0; i<array.length;i++) {
				System.out.println("Scrivi la parola che vuoi inserire");
				String parola = sc.nextLine();
				if(!s.contains(parola)) {
					s.add(parola);
				}else {
					log.error("Parola già presente: " + parola);
				}
				int size1 = s.size();
				log.info("Grandezza: " + size1);
			}
			
		}catch(NumberFormatException e) {
			log.error("Numero non valido");
		
			
		}
		boolean duplicate = s.isEmpty();
		log.info("Lista vuota?: " + duplicate);
		int sizeTotale = s.size();
		log.info("Numero totale parole: " + sizeTotale);
		log.info("Array: " + s.toString());
	}

	@Override
	public String toString() {
		return "MainProject []";
	}
}
