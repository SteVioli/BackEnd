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
		pariDispari(lista,false);
	}
	static List<Integer> lista = new ArrayList<Integer>();
	static List<Integer> listaOk;

	// volendo si può creare anche una funzione che accetti una lista come parametro, dovrò dichiararne una nuova all'interno
	// dentro la funzione List<Integer> listaOk = new ArrayList<Integer>();
	// e mettere alla fine RETURN listaOk;
	
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
	
	static public void pariDispari(List<Integer> lista2, boolean b) {
		
		if(b) {
			for (int i = 0; i < lista2.size(); i= i +2) {
				
					System.out.print(lista2.get(i) + " ");
				}
			}
						
			else {
				for (int i = 0; i < lista2.size(); i++) {
					if(i %2 != 0) {
						
					System.out.print(lista2.get(i) + " ");
				
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "es02 []";
	}
}
