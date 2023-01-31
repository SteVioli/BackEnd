package corso_java;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Project");
		
		//ISTANZIO UN OGGETTO
		//devo tipizzare il mio oggetto
		
		/*Veicolo v = new Veicolo();
		//ho creato un oggetto con tutte le 		caratteristiche dell oggetto veicolo
		v.marca = "Fiat";
		v.modello = "500";
		v.colore = "Nera";
		v.targa = "AB123CD";
		v.cilindrata = 1200;*/
		
		Veicolo v1 = new Veicolo("500", "Fiat","AB123CD", "nera", 1200);
		Veicolo v2 = new Veicolo("Fiesta", "Ford", 1200);
		v2.colore = "Bianco";
		v2.targa = "AA123NB";
		
		Veicolo v3 = new Veicolo("X5", "BMW", "Verde", 1200);
		v3.targa = "BB324AA";
		
		Veicolo v4 = new Veicolo("500", "Fiat","AB123CD", "nera", 1200);
		
		System.out.println(v1.info());
		System.out.println(v2.info());
		System.out.println(v3.info());
		
		
		int x = 5;
		int y = 5;
		
		System.out.println(x==y);
		System.out.println(v1==v4);
	
	}

}
