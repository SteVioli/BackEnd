package es02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class es02 {
	static	Logger log = LoggerFactory.getLogger(es02.class);
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		generaLista100();
		nuovaListaOrdinata();
		//pariDispari(lista,true);
	}
	static List<Integer> lista = new ArrayList<Integer>();
	
	static public void generaLista100() {
		System.out.println("scrivi un numero");
		try {
			int numero = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < numero; i++) {
				lista.add((int)(Math.random()*100+1));
			}
		}catch(NumberFormatException e) {
			log.error("numero non valido");
			generaLista100();
		}
		log.info("Lista generata: " + lista.toString());
	}
	
	static public void nuovaListaOrdinata() {
			log.info("ListaOrdinata");
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
			Collections.reverse(lista);
			log.info("Nuova lista ordine inverso: " + lista.toString());
	}
	
	static public void pariDispari(ArrayList<Integer> lista, boolean b) {
		
		if(b == true) {
			for (int i = 0; i < lista.size(); i++) {
				if(i %2 == 0) {
					log.info("lista indici pari" + lista.indexOf(lista));
								}
						
				else {
					log.info("lista indici dispari" + lista.indexOf(lista));
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "es02 []";
	}
}
