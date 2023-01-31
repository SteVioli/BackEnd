package esercizio2_31_01;

public class Sim {
	int tNumber;
	int credit;
	Chiamata [] chiamate;
	
	public Sim(int tNumber) {
		this.tNumber = tNumber;
		this.credit = 0;
		this.chiamate= new Chiamata[5];
		
	}

	public void simInfo(Sim sim) {

		System.out.println("Numero: " + sim.tNumber + " " + " Credito: " + sim.credit);
		System.out.println("Ultime Chiamate:");
		
		if(sim.chiamate[0] != null  ) {
		System.out.println("Chiamata 1: " + "Numero: " + sim.chiamate[0].phone + ", Durata: " + 		sim.chiamate[0].minutes);}
		if(sim.chiamate[1] != null  ) {
		System.out.println("Chiamata 2: " + "Numero: " + sim.chiamate[1].phone + ", Durata: " + 		sim.chiamate[1].minutes);}
		if(sim.chiamate[2] != null  ) {
		System.out.println("Chiamata 3: " + "Numero: " + sim.chiamate[2].phone + ", Durata: " + 		sim.chiamate[2].minutes);}
		if(sim.chiamate[3] != null  ) {
		System.out.println("Chiamata 4: " + "Numero: " + sim.chiamate[3].phone + ", Durata: " + 		sim.chiamate[3].minutes);}
		if(sim.chiamate[4] != null  ) {
		System.out.println("Chiamata 5: " + "Numero: " + sim.chiamate[4].phone + ", Durata: " + 		sim.chiamate[4].minutes);}
		if (sim.chiamate[0] == null && sim.chiamate[1] == null && sim.chiamate[2] == null && sim.chiamate[3] == null 		&& sim.chiamate[4] == null) {
			System.out.println("Registro Chiamate vuoto");
		}
	}
	
	public void simRecharge(Sim sim, int credit) {
		sim.credit+= credit;
		System.out.println("Effettuata ricarica di  " + credit +"€." + " Il tuo nuovo credito è di: " + sim.credit);
		
	
	}
	
	public String toString(Sim sim) {
		return "Numero chiamate [Chiamata 1:" + sim.chiamate[0] +" " + 
				"Chiamata 2:" + sim.chiamate[1] +" " +
				"Chiamata 3:" + sim.chiamate[2] +" " +
				"Chiamata 4:" + sim.chiamate[3] +" " +
				"Chiamata 5:" + sim.chiamate[4] +" " +
					"]";
	}
	

}


