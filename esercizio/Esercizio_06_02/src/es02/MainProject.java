package es02;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//ESERCIZIO 2
		kmLitro();
	}
	
	public static void kmLitro() {
		System.out.println("Inserire KM");
		int km = richiestaNumeri();
		System.out.println("Inserire LITRI");
		int litro = richiestaNumeri();
		try {
		System.out.println("Numero km/litro selezionato: " + (km/litro));
		}catch (ArithmeticException e) {
			System.out.println("Dichiarare numeri diversi da 0, operazione non definita");
			kmLitro();
		}
	}
	
	public static int richiestaNumeri() {
		System.out.println("Inserisci numero: ");
		try {
			return Integer.parseInt(sc.nextLine());
		}catch (ArithmeticException e) {
			System.out.println("Errore, impossibile selezionare i litri o i km con un valore pari a 0 o inferiore");
			return richiestaNumeri();
		}catch (NumberFormatException e) {
			System.out.println("Errore, impossibile selezionare i litri o i km con un valore diverso da un numero");
			return richiestaNumeri();
		}
	}
}
