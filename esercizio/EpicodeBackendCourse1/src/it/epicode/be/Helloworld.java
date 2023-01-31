package it.epicode.be;

import java.util.ArrayList;
import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		int aA = 5;
		int bB = 4;
		int resMoltiplica = moltiplica(aA,bB);
		System.out.println("Il risultato della moltiplicazione di " + aA + " e " + bB + " è di: " + resMoltiplica);
		
		
		String cC = "MiaStringa";
		String resConcatena = concatena(cC,aA);
		System.out.println("Il risultato della concatenazione di " + cC + " e " + aA + " è di: " + resConcatena);
		
		String[] dD = new String[] {"uno","due","tre","quattro","cinque"};
		String []newArray = inserisciInArray(dD,cC);
		System.out.println("Array: " );
		System.out.println("New Array: ");
		
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		
		//SECONDO ESERCIZIO
		int numeroUno = 5;
		int numeroDue = 3;
		int prodotto = numeroUno*numeroDue;
		System.out.println("es2-----------------");
		System.out.println("Prodotto: "+ prodotto);
		
		//TERZO ESERCIZIO
		int esTRE = 5;
		String sTre = "prova";
		System.out.println("es3-----------------");
		System.out.println("Concatenazione: " + sTre + Integer.valueOf(esTRE));
		
		//QUARTO ESERCIZIO
		
		
		
		String arr[]= new String []{"1","2","3","4","5"};
		System.out.println(arr.length);
		
		ArrayList<String> values = new ArrayList<>();
		values.add("a");
		values.add("b");
		values.add("c");
		values.add("d");
		values.add("e");
		values.add(2,"Nuova Stringa");
		
		System.out.println("es4----------------");
		System.out.println(values);
		
		//QUINTO ESERCIZIO
		
		Scanner sc = new Scanner(System.in);
		System.out.print("prima stringa: ");
		String stringaUno = sc.nextLine();
		System.out.print("seconda stringa: ");
		String stringaDue = sc.nextLine();
		System.out.print("terza stringa: ");
		String stringaTre = sc.nextLine();
		System.out.println("es5----------------");
		String arrEsQ[] = {stringaUno,stringaDue,stringaTre};
		System.out.println(stringaUno + " " + stringaDue + " " + stringaTre);
		System.out.println(stringaTre + " " + stringaDue + " " + stringaUno);
		
		//SESTO ESERCIZIO
		System.out.print("primo lato (valori decimali consentiti): ");
		double lUno = sc.nextDouble();
		System.out.print("secondo lato (valori decimali consentiti): ");
		double lDue = sc.nextDouble();
		double perimetroRettangolo = lUno*lDue;
		System.out.println("es6---------------");
		System.out.println(perimetroRettangolo);
		
		//SETTIMO ESERCIZIO
		System.out.println("es7---------------");
		System.out.print("inserire un numero intero: ");
		int numInt = sc.nextInt();
		if (numInt %2==0){
			System.out.println("Numero pari: " + 0);
			}else {
				System.out.println("Numero dispari: "+ 1);
			}
		
		//OTTAVO ESERCIZIO
		System.out.println("es8----------------");
		System.out.print("inserire lunghezza decimale base: ");
		double triBase = sc.nextDouble();
		System.out.print("inserire lunghezza decimale altezza: ");
		double triAltezza = sc.nextDouble();
		System.out.println("area triangolo: " + (triBase*triAltezza)/2);
		}
		
		public static int moltiplica(int x,int y) {
			return x*y;
		}
		
		public static String concatena(String x, int y) {
			return "Str: "+ x + " - Int: " + y;
		}
		
		public static String[] inserisciInArray(String[]inputArr , String str) {
			String[] arr = new String[6];
			arr[0] = inputArr[0];
			arr[1] = inputArr[1];
			arr[2] = str;
			arr[3] = inputArr[2];
			arr[4] = inputArr[3];
			arr[5] = inputArr[4];
			
			return arr;
			
		}
	}

		
		
		
	




