package corso_java;

public class Veicolo {
	
	//DEFINISCO LA MIA CLASSE CON COSA DEVE AVERE DI CARATTERISTICHE (ATTRIBUTI)
	String modello;
	String marca;
	String targa;
	String colore;
	int cilindrata;
	
	//DEFINISCO I METODI DELLA CLASSE , costruito da un modificatore di accesso, un valore di ritorno
	//un nome (PUBLIC-VOID-NOME() ) <---- esempio
	
	public Veicolo(String modello,String marca,String targa, String colore, int cilindrata) {
		//questo è un costruttore in JAVA
		//prende in ingresso tramite parametri tutte le caratteristiche del veicolo
		
		this.modello = modello;
		this.marca = marca;
		this.targa = targa;
		this.colore = colore;
		this.cilindrata = cilindrata;
		
	}
	
	public Veicolo(String modello, String marca,int cilindrata) {
		this.modello = modello;
		this.marca = marca;
		this.cilindrata = cilindrata;
	}
	public Veicolo (String modello, String marca,String colore,int cilindrata) {
		this.modello = modello;
		this.marca = marca;
		this.cilindrata = cilindrata;
		this.colore = colore;
	}
	
	
	
	
	public void start() {
		System.out.println("Veicolo avviato");
	}
	
	public void stop() {
		System.out.println("Veicolo fermo");
	}
	
	public String info() {
		return this.marca + " " + this.modello + " " +
				this.colore + " cc. " + this.cilindrata + 
				" targa: " + this.targa;
	}
}
