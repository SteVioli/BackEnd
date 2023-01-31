package corso_java;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ciao a tutti"); //Stampare su console
		
		int varx; //dichiarazione di una variabile
		varx = 25; //inizializzazione di una variabile
		int vary = 10; //Dichiarazione ed inizializzazione di una variabile
		
		int arr[] = new int[5]; //dichiarazione di un array ( quanti argomenti deve avere )
		arr[0] = 25; 
		int arry[] = {25,12,99};
		
		int n = 25;
		double f = 25.5;
		char c = 'h';
		boolean b = true;
		String s = "stringa";
		String ss = "15";
		
		double db = n;  //metto in questo caso un valore intero dentro ad un double che è caratterizzato dalla virgola (lo trasforma in 25.0)
		// è il cast implicito, ovvero una trasformazione di dati senza perdita di valori
		
		
		int id = (int) f; //con (int) faccio un cast esplicito , dove forzo la trasformazione
		
		int is = Integer.parseInt(ss);   // trasformo una stringa col metodo parseInt in un numero
		
		
		int num1 = 10;
		int num2 = 3;
		int res = num1/num2;
		System.out.println(res);   // java vuole un intero, quindi anche se è un numero periodico lo taglia, ( 3.333333 diventa 3 , 
		//taglia tutto quello che c'è dopo la virgola
		
		int mod = num1%num2;
		System.out.println(mod);
		
		double r = num1/num2;
		System.out.println(r); // stampa un numero con .0 se voglio i valori con la virgola, devo mettere una delle 2 variabili come double
		
		
		//CREO L'OGGETTO SCANNER, devo creare una variabile capace di contentere un oggetto di tipo scanner
		
		Scanner sc = new Scanner(System.in); //dovrò importare lo scanner
		System.out.print("Scrivi il tuo nome: ");
		String nome = sc.nextLine();
		System.out.println("Ciao " + nome);
		System.out.print("Quanti hanni hai? ");
		int eta = Integer.parseInt(sc.nextLine());
		if(eta > 18) {
			System.out.println("Sei maggiorenne");
		}else {
			System.out.println("Sei minorenne");
		}
		stampa();
	}
	
	public static void stampa() {
		System.out.println("FINE");
	}
	
}
