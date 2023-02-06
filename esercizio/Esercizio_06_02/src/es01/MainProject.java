package es01;

import java.util.Iterator;
import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// ESERCIZIO 1
		System.out.println("Inizio Operazione");
		generaArray();
	}
	
	static int[] arrayNumeri = new int[5];
	
	
	
	public static void generaArray() {
		System.out.println("Generazione automatica 5 numeri casuali tra 1 e 10");
		for (int i = 0; i < arrayNumeri.length; i++) {
			arrayNumeri[i] = random(1,10);
			System.out.println(arrayNumeri[i]);	
		}
		arrayPersonale();
		for (int i = 0; i < arrayNumeri.length; i++) {
		System.out.println(arrayNumeri[i]);
		}
	}
	
	private static void arrayPersonale() {
		System.out.println("Scegli un numero: ");
		int sceltaNumero = 0;
		try {
		sceltaNumero = Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			System.out.println("Campo Form non valido, inserire un numero!");
			arrayPersonale();
		}
		System.out.println("Scegli in che posizione vuoi metterlo da 1 a 5, per uscire premere 0 e visualizzare il nuovo array digita 123456: ");
		int sceltaPosizione = 0;
		try {
			sceltaPosizione = Integer.parseInt(sc.nextLine());
			
		}catch (NumberFormatException e) {
			System.out.println("Scegli in che posizione vuoi metterlo da 1 a 5, per uscire premere 0 e visualizzare il nuovo array digita 123456: ");
			arrayPersonale();
		}
		switch(sceltaPosizione) {
			case 1: {
				arrayNumeri[0] = sceltaNumero;
				arrayPersonale();
				
				break;
			}
			case 2: {
				arrayNumeri[1] = sceltaNumero;
				arrayPersonale();
				break;
			}
			case 3: {
				arrayNumeri[2] = sceltaNumero;
				arrayPersonale();
				break;
			}
			case 4: {
				arrayNumeri[3] = sceltaNumero;
				arrayPersonale();
				break;
			}
			case 5: {
				arrayNumeri[4] = sceltaNumero;
				arrayPersonale();
				break;
			}
			case 0:{
				System.out.println("Sei uscito");
				return;
			}
				default:{
				System.out.println("errore");
				arrayPersonale();
			}
		}
	}
	
	
	private static int random(int min, int max) {
		int range = (max-min)+1;
		return (int)(Math.random()*range) + min;
	}
		
}
