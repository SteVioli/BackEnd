package es04;


import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Inserisci un numero da dove fare partire il countdown: ");
		int numero =  Integer.parseInt(sc.nextLine());
		
		countDown(numero);
	}
	
	public static void countDown(int numero) {
		int i = 0;
		for(i = 0; i<= numero;i++) {
			int c = numero -i;
			System.out.println(c);
		}
	}
}
