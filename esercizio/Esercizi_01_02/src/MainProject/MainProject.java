package MainProject;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		

		pariDispari();
		annoBisestile();
		}
		
		
		
	
		public static void pariDispari() {
			System.out.print("Inserisci una parola a tua scelta: ");
			String str = sc.nextLine();
			if((str.length())%2 == 0) {
				System.out.println("Caratteri della stringa PARI");
			}else {
				System.out.println("Caratteri della stringa DISPARI");
			}
	
		}
		public static void annoBisestile() {
			System.out.print("Inserisci un anno a tua scelta: ");
			int anno =Integer.parseInt(sc.nextLine());
			if((anno % 4 == 0) || ( (anno % 400 == 0)&& (anno % 100 != 0))) {
				System.out.println("L'anno: " + anno + " è bisestile");
			}else{
					System.out.println("L'anno: " + anno + " non è bisestile");
				}
				
		}
}
