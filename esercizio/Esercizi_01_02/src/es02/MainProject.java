package es02;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {
		System.out.print("inserisci un numero: ");
		int intero = Integer.parseInt(sc.nextLine());
		switch (intero) {
		case 0: {
			System.out.println("zero");
			break;
		}
		case 1: {
			System.out.println("uno");
			break;
		}
		case 2: {
			System.out.println("due");
			break;
		}
		case 3: {
			System.out.println("tre");
			break;
		}
		default: {
			System.out.println("numero non valido");
			return;
		}
		}
	}
	}
	
	
}
