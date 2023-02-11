package CatalogoBibliotecario;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {
	static File file = new File("direFile/archivio.txt");
	static Scanner sc = new Scanner(System.in);
	static Logger log = LoggerFactory.getLogger(Archivio.class);
	static	List<CatalogoBibliotecario> catalogoBiblio = new ArrayList<CatalogoBibliotecario>();
	
	
	public static void main(String[] args) {

		avvioArchivio();		
		
	}
	
	
	static public void avvioArchivio() {
		try {
			caricamentoDaDisco();
		} catch (IOException e1) {
			log.error("File non trovato!");
		}
		log.info("Accesso all'archivio comunale");
		log.info("Scegli quale operazione effettuare");
		log.info("(1) Aggiungi Elemento");
		log.info("(2) Rimuovi Elemento");
		log.info("(3) Ricerca Elemento per anno di pubblicazione");
		log.info("(4) Ricerca Elemento per autore");
		log.info("(5) Ricerca Elemento per ISBN code");
		log.info("(6) Salva dati nell'archivio");
		log.info("(7) Carica dati dall'archivio");
		log.info("(8) Visualizza archivio");
		log.info("(9) Cancella file archivio");
		log.info("(10) Cancella Directory archivi");
		log.info("(0) Esci");
		
		try {
		int scelta = Integer.parseInt(sc.nextLine());
		switch (scelta) {
		case 1: {
			aggiungiElemento();
			break;
		}
		case 2: {
			rimuoviElemento();	
			break;		
				}
		case 3: {
			ricercaPerAnnoPubblicazione();
			break;
		}
		case 4: {
			ricercaPerAutore();
			break;
		}
		case 5: {
			ricercaElementoConIsbn();
			break;
		}
		case 6: {
			try {
				salvaSuDisco();
				log.info("-----------------------------");
				System.out.println("File salvato correttamente");
				log.info("-----------------------------");
			} catch (IOException e) {
				log.error(e.getMessage());;
			}
			break;
		}
		case 7: {
				caricamentoDaDisco();
				log.info("-----------------------------");
				System.out.println("File caricato correttamente");
				log.info("-----------------------------");
			break;
		}
		case 8: {
			visualizzaArchivio();
			avvioArchivio();
			break;
		}
		case 9:{
			cancellaFile();
			avvioArchivio();
			break;
		}
		case 10:{
			cancellaDirectory();
			avvioArchivio();
			break;
		}
		case 0: {
			log.info("-----------------------------");
			log.info("Sei uscito dall'applicazione");
			log.info("-----------------------------");
			return;
		}
		default:
			log.info("-----------------------------");
			log.error("Opzione non valida");
			log.info("-----------------------------");
			avvioArchivio();
			break;
		}
	}catch(NumberFormatException e) {
		log.info("-----------------------------");
		log.error("Valore non riconosciuto");
		log.info("Applicazione terminata");
		log.info("-----------------------------");
	} catch (IOException e) {
		
		e.getMessage();
	}
	}
	
	// dichiarazione metodo per aggiungere l'elemento dell'archivio
	// fatto con switch per far scegliere all'utente se creare
	// LIBRO o RIVISTA 
	static public void aggiungiElemento() {
		System.out.println("Scegli che tipo di Elemento aggiungere");
		System.out.println("(1) Libro -- (2) Rivista ");
		try {
		int scelta = Integer.parseInt(sc.nextLine());
		
		switch (scelta) {
		case 1: {
				log.info("Inserisci dati LIBRO");
				log.info("---------------------");

				log.info("Dichiara il TITOLO del tuo libro");
				String titolo = sc.nextLine();
				log.info("Dichiara l' ANNO di pubblicazione");
				Integer anno = Integer.parseInt(sc.nextLine());	
				log.info("Dichiara il NUMERO DI PAGINE del tuo libro");
				int numPagine = Integer.parseInt(sc.nextLine());
				log.info("Dichiara l' AUTORE del tuo libro");
				String autore = sc.nextLine();
				log.info("Dichiara il GENERE del tuo libro");
				String genere = sc.nextLine();
				
				log.info("Dichiara il codice ISBN");
				Integer codeIsbn = Integer.parseInt(sc.nextLine());
						codeIsbnNonRipetibile(codeIsbn);
						catalogoBiblio.add(new Libri(codeIsbn,titolo,anno,numPagine,autore,genere));
						
			//		}
			//	}
				avvioArchivio();
				break;
		}
		case 2: {
				log.info("Inserisci dati RIVISTA");
				log.info("-----------------------------");
				log.info("Dichiara il codice ISBN");
				Integer codeIsbn = Integer.parseInt(sc.nextLine());
				codeIsbnNonRipetibile(codeIsbn);

				log.info("Dichiara il TITOLO della tua rivista");
				String titolo = sc.nextLine();
				log.info("Dichiara l' ANNO di pubblicazione");
				Integer anno = Integer.parseInt(sc.nextLine());
				log.info("Dichiara il NUMERO DI PAGINE della tua rivista");
				int numPagine = Integer.parseInt(sc.nextLine());
				log.info("Scegli la PERIODICITA' ");
				
// Per la selezione della periodicità utilizzo un altro switch per utilizzare più comodamente gli ENUM richiesti con l'aggiunta diretta
// della rivista nel mio set 
				System.out.println("(1) Settimanale - (2) Mensile - (3) Semestrale");
				int sceltaPer = Integer.parseInt(sc.nextLine());
				switch (sceltaPer) {
				case 1: {
					Periodicità sett = Periodicità.SETTIMANALE;
					catalogoBiblio.add(new Riviste(codeIsbn,titolo,anno,numPagine,sett));
					avvioArchivio();
					break;
				}
				case 2: {
					Periodicità mens = Periodicità.MENSILE;	
					catalogoBiblio.add(new Riviste(codeIsbn,titolo,anno,numPagine,mens));
					avvioArchivio();
					break;
				}
				case 3: {
					Periodicità semest = Periodicità.SEMESTRALE;
					catalogoBiblio.add(new Riviste(codeIsbn,titolo,anno,numPagine,semest));
					avvioArchivio();
					break;
				}
				default:
					log.error("Opzione non valida");
				}
				
		}
		
		}
		}catch (NumberFormatException e) {
			log.error("ERRORE COMPILAZIONE");
			log.error("Applicazione Archivio Terminata");
		}
	}
	
	//METODO PER RICERCA TRAMITE AUTORE
	//METODO PER RICERCA TRAMITE AUTORE
	//METODO PER RICERCA TRAMITE AUTORE
	
	static public void ricercaPerAutore() {	
		//simile alle altre ricerche ma devo aggiungere una ricerca per
		//filter aggiuntiva perchè devo prima identificare che TIPO sono
		System.out.println("Scrivi l'Autore per effettuare la ricerca");
		String autore = sc.nextLine();
		Stream<CatalogoBibliotecario> catAutore = catalogoBiblio.stream()
				.filter(ele-> ele instanceof Libri)
				.filter(ele ->  ((Libri) ele).getAutore().equals(autore));
		catAutore.forEach(ele-> System.out.println(ele));
		avvioArchivio();
	}	

	//METODO PER RIMUOVERE ELEMENTO
	//METODO PER RIMUOVERE ELEMENTO
	//METODO PER RIMUOVERE ELEMENTO

	static public void rimuoviElemento() {
		System.out.println("Seleziona il codice ISBN per rimuovere il rispettivo elemento");
			Integer isbnScelto = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < catalogoBiblio.size(); i++) {
				if(catalogoBiblio.get(i).getCodeIsbn() == isbnScelto) {
					catalogoBiblio.remove(i);
					log.info("Elemento con code ISBN: " + isbnScelto + " eliminato!");
					log.info("-----------------------------");
				}else {
					log.error("Code ISBN non trovato");
					log.info("-----------------------------");

				}
			}
			avvioArchivio();
					
	}
	
	//METODO PER VISUALIZZARE ARCHIVIO
	//METODO PER VISUALIZZARE ARCHIVIO
	//METODO PER VISUALIZZARE ARCHIVIO

	static public void visualizzaArchivio() {
		//ciclo for degli elementi del mio catalogo e relativa stampa
		if(catalogoBiblio.isEmpty()) {
			System.out.println("Archivio Vuoto!!");
			log.info("-----------------------------");

			avvioArchivio();
		}else {
		catalogoBiblio.forEach(ele -> System.out.println(ele));
		avvioArchivio();
		}
	}

	//METODO PER RICERCA TRAMITE ANNO
	//METODO PER RICERCA TRAMITE ANNO
	//METODO PER RICERCA TRAMITE ANNO

	static public void ricercaPerAnnoPubblicazione() {
		//stream del catalogo con filtro che cerca per ogni elemento
		//l'anno di pubblicazione se uguale al parametro dato dall utente
		//e relativa stampa
		
		System.out.println("Inserisci l'anno di pubblicazione");
		log.info("-----------------------------");
		Integer anno = Integer.parseInt(sc.nextLine());
		Stream<CatalogoBibliotecario> catFiltroAnno = catalogoBiblio.stream()
				.filter(ele -> ele.getAnnoPubblicazione().equals(anno));
				log.info("-----------------------------");
				catFiltroAnno.forEach(ele -> System.out.println(ele));
				log.info("-----------------------------");
				avvioArchivio();
	}
	
	//METODO PER RICERCA TRAMITE ISBN CODE
	//METODO PER RICERCA TRAMITE ISBN CODE
	//METODO PER RICERCA TRAMITE ISBN CODE

	static public void ricercaElementoConIsbn() {
		//speculare alla ricerca anno
		System.out.println("Inserisci il codice ISBN");
		Integer isbnCode = Integer.parseInt(sc.nextLine());
		Stream<CatalogoBibliotecario> catFiltroIsbn = catalogoBiblio.stream()
				.filter(ele -> ele.getCodeIsbn().equals(isbnCode));
		log.info("-----------------------------");
		catFiltroIsbn.forEach(ele -> System.out.println(ele));
		log.info("-----------------------------");
		avvioArchivio();
	}
	
	//METODO PER AVERE ISBN CODE UNICO
	//METODO PER AVERE ISBN CODE UNICO
	//METODO PER AVERE ISBN CODE UNICO

	public static void codeIsbnNonRipetibile(Integer code) {
		//subito avevo provato a scrivere sotto al sc.nextline
//		for (int i = 0; i < catalogoBiblio.size(); i++) {
//		if(catalogoBiblio.get(i).getCodeIsbn() == codeIsbn) {
//			log.error("ISBN già in uso!!!");
//			avvioArchivio();
//		}}
		// ma non mi prendeva alcun valore o inserimento, rimaneva tutto vuoto. ho provato a "forzarlo" creando un metodo apposito e fortunatamente funziona. il code ISBN non può essere ripetuto
		
		//faccio un ciclo sugli indici esistenti della lista per verificare l'esistenza di 1 ISPN code per evitare di ripeterlo, in quanto voglio che sia univoco
		for (int i = 0; i < catalogoBiblio.size(); i++) {
			if(catalogoBiblio.get(i).getCodeIsbn() == code) {
				log.error("ISBN già in uso!!! ripetere operazione");
				avvioArchivio();
			}
		}
	}

	//METODO PER SALVARE SU DISCO -con aggiunti di caratteri per dividere elementi e proprietà
	//METODO PER SALVARE SU DISCO -con aggiunti di caratteri per dividere elementi e proprietà
	//METODO PER SALVARE SU DISCO -con aggiunti di caratteri per dividere elementi e proprietà
	
	static public void salvaSuDisco() throws IOException {

		//salvo su cartella i miei dati
		
		for (int i = 0; i < catalogoBiblio.size(); i++) {
			if(catalogoBiblio.get(i) instanceof Libri) {
				FileUtils.writeStringToFile(file, catalogoBiblio.get(i).getCodeIsbn() + "!" + catalogoBiblio.get(i).getTitolo() + "#" + catalogoBiblio.get(i).getAnnoPubblicazione() + "@" + catalogoBiblio.get(i).getNumeroPagine() + "+" + ((Libri) catalogoBiblio.get(i)).getAutore() + "*" + ((Libri) catalogoBiblio.get(i)).getGenere() + "-" , "UTF-8", true);
			}else if (catalogoBiblio.get(i) instanceof Riviste) {
				FileUtils.writeStringToFile(file,catalogoBiblio.get(i).getCodeIsbn() + "!" + catalogoBiblio.get(i).getTitolo() + "=" + catalogoBiblio.get(i).getAnnoPubblicazione() + "@" + catalogoBiblio.get(i).getNumeroPagine() + "+" + ((Riviste) catalogoBiblio.get(i)).getPeriodicita() + "-" , "UTF-8", true);
			}
		}
		avvioArchivio();
	}

	//METODO PER CARICARE DA DISCO
	//METODO PER CARICARE DA DISCO
	//METODO PER CARICARE DA DISCO

	static public void caricamentoDaDisco() throws IOException {
		//cancello il catalogo per fare il check
		catalogoBiblio.clear();
		
//		FileReader fr = new FileReader(file);
//		//ciclo while che finchè esiste qualcosa mi stampa cosa c'è
//		int i;
//		System.out.println("Lettura in linea contenuto codificato del file");
//		System.out.println("----------------");
//		while ((i = fr.read()) != -1) {
//			System.out.print((char)i);
//		}
		String fileStringa = FileUtils.readFileToString(file,"UTF-8");
		String[] divisioneFile = fileStringa.split("-");
		for (int j = 0; j < divisioneFile.length; j++) {
			if(divisioneFile[j].contains("#")) {
			Integer codeIsbn = Integer.parseInt( divisioneFile[j].substring(0, divisioneFile[j].indexOf("!")));
			String titolo = divisioneFile[j].substring(divisioneFile[j].indexOf("!")+1, divisioneFile[j].indexOf("#"));
			Integer annoPubblicazione = Integer.parseInt( divisioneFile[j].substring(divisioneFile[j].indexOf("#")+1, divisioneFile[j].indexOf("@")));
			int numeroPagine = Integer.parseInt( divisioneFile[j].substring(divisioneFile[j].indexOf("@")+1, divisioneFile[j].indexOf("+")));
			String autore = divisioneFile[j].substring(divisioneFile[j].indexOf("+")+1, divisioneFile[j].indexOf("*"));
			String genere = divisioneFile[j].substring(divisioneFile[j].indexOf("*")+1);
			catalogoBiblio.add(new Libri(codeIsbn,titolo,annoPubblicazione,numeroPagine,autore,genere));
			}
			else if(!divisioneFile[j].contains("#")) {
			
				Integer codeIsbn = Integer.parseInt( divisioneFile[j].substring(0, divisioneFile[j].indexOf("!")));
				String titolo = divisioneFile[j].substring(divisioneFile[j].indexOf("!")+1, divisioneFile[j].indexOf("="));
				Integer annoPubblicazione = Integer.parseInt( divisioneFile[j].substring(divisioneFile[j].indexOf("=")+1, divisioneFile[j].indexOf("@")));
				int numeroPagine = Integer.parseInt( divisioneFile[j].substring(divisioneFile[j].indexOf("@")+1, divisioneFile[j].indexOf("+")));
				String riv = divisioneFile[j].substring(divisioneFile[j].indexOf("+")+1);
				switch(riv) {
				case "SETTIMANALE":{
					Periodicità sett = Periodicità.SETTIMANALE;
					catalogoBiblio.add(new Riviste(codeIsbn,titolo,annoPubblicazione,numeroPagine,sett));
					break;
				}
				case "MENSILE":{
					Periodicità sett = Periodicità.MENSILE;
					catalogoBiblio.add(new Riviste(codeIsbn,titolo,annoPubblicazione,numeroPagine,sett));
					break;
				}
				case "SEMESTRALE":{
					Periodicità sett = Periodicità.SEMESTRALE;
					catalogoBiblio.add(new Riviste(codeIsbn,titolo,annoPubblicazione,numeroPagine,sett));
					break;
				}
				}
			}
		}
		avvioArchivio();
	}



	public static void cancellaFile() throws IOException {
		FileUtils.deleteQuietly(file);
		System.out.println("File Archivio Eliminato");
	}
	public static void cancellaDirectory() throws IOException {
		File file = new File("direFile/");
		FileUtils.deleteDirectory(file);
		System.out.println("Cartella Archivi Eliminata");
	}
}

