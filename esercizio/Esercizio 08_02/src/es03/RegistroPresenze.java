package es03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {
	
	static Scanner sc = new Scanner(System.in);
	static File file = new File("direFile/test.txt");
	static Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
	static List<Utente> list = new ArrayList<Utente>();
	
	
	
	public static void main(String[] args) {
		
		while(true) {
		System.out.println("Cosa vuoi fare? (1)Scrivi le tue presenze (2)Leggi le tue presenze (3)Cancella file (4)Cancella cartella (5)Esci" );
		try {
			int scelta =Integer.parseInt(sc.nextLine());
			switch(scelta) {
				case 1:try {
					scriviPresenze();
					break;
				}catch (IOException e) {
					log.error(e.getMessage());
				}
				case 2: {
					try {
					leggiPresenze();
					break;
				}catch (IOException e) {
						log.error("Numero Non Valido");
					}
				}case 3:{
						cancellaFile();
						break;
				}case 4:{
					try {
						cancellaDirectory();
					} catch (IOException e) {
						log.error("Errore: Opzione non valida");
					}
					break;
				}
				case 5:{
					return;
				}default :{
					log.error("opzione non valida");
				}
			}
			}catch(NumberFormatException e) {
				log.error("Numero Non Valido");
			}
		}
		
	}
	
	public static void scriviPresenze() throws IOException {
		System.out.println("Digita il tuo nome");
		String nome = sc.nextLine();
		System.out.println("Digita il tuo cognome");
		String cognome = sc.nextLine();
		System.out.println("Digita le tue presenze");
		try {
		int presenze =Integer.parseInt(sc.nextLine());
		FileUtils.writeStringToFile(file,nome + " " + cognome +"@" + presenze +"#", "UTF-8",true);
		}catch(NumberFormatException e) {
			log.error("Numero Non Valido");
		}
		
	}
	public static void leggiPresenze() throws IOException {
		String txtFile = FileUtils.readFileToString(file,"UTF-8");
		String[] arr = txtFile.split("#");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			String nome = arr[i].substring(0, arr[i].indexOf(" "));
			String cognome = arr[i].substring(arr[i].indexOf(" "), arr[i].indexOf("@"));
			String presenze = arr[i].substring(arr[i].indexOf("@")+1);
			
			Utente user = new Utente(nome, cognome, presenze);
			list.add(user);
		}
		System.out.println(list);
	}
	public static void cancellaFile() {
		FileUtils.deleteQuietly(file);
		System.out.println("File Presenze eliminato");
	}
	public static void cancellaDirectory() throws IOException {
		File file = new File("dirFile/");
		FileUtils.deleteDirectory(file);
		System.out.println("Directory Registro Presenze Eliminata");
	}
}
