package es03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class es03 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mappaTelefono();
	}
	public static void mappaTelefono() {
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		
		System.out.println("inserisci nome");
		String nome = sc.nextLine();
		System.out.println("inserisci numero di telefono");
		Integer numeroTelefono = Integer.parseInt(sc.nextLine());
		m.put(nome, numeroTelefono);
		System.out.println("mappa: " + m);
		
		System.out.println("inserisci nome");
		String nome1 = sc.nextLine();
		System.out.println("inserisci numero di telefono");
		Integer numeroTelefono1 = Integer.parseInt(sc.nextLine());
		m.put(nome1, numeroTelefono1);
		System.out.println("mappa: " + m);
		
		System.out.println("inserisci nome");
		String nome2 = sc.nextLine();
		System.out.println("inserisci numero di telefono");
		Integer numeroTelefono2 = Integer.parseInt(sc.nextLine());
		m.put(nome2, numeroTelefono2);
		System.out.println("mappa: " + m);
		
		System.out.println("cancella contatto, inserisci nome: ");
		String nomeDaCancellare = sc.nextLine();
		m.remove(nomeDaCancellare);
		System.out.println("mappa: " + m);
		
		System.out.println("trova un contatto, inserisci num. telefono: ");
		Integer numeroDaCercare = Integer.parseInt(sc.nextLine());
		Integer a = m.get(numeroDaCercare);
		System.out.println("Contatto trovato: " + a);
		
		
		
		System.out.println("cerca un num di telefono inserendo il nome del proprietario");
		String nomeTrovato = sc.nextLine();
		Integer nomeOk = m.get(nomeTrovato);
		System.out.println(nomeOk);
		
		System.out.println("rubrica completa: " + m);
	}
	@Override
	public String toString() {
		return "es03 []";
	}
}
