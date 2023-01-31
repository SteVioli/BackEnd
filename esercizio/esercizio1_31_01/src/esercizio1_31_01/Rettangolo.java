package esercizio1_31_01;

public class Rettangolo {

	int altezza;
	int larghezza;
	
	public Rettangolo (int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public String stampaRettangolo(Rettangolo r) {
		return this.altezza*this.larghezza + " è l'area del Rettangolo, mentre " + ((this.altezza*2)+(this.larghezza*2))+ " è il perimetro del Rettangolo";

	}
	public void stampaDueRettangoli(Rettangolo uno, Rettangolo due) {
		int unoArea = uno.altezza*uno.larghezza;
		System.out.println(unoArea + " è l'area del primo triangolo");
		int unoPerimetro = (uno.altezza*2)+(uno.larghezza*2);
		System.out.println(unoPerimetro + " è il perimetro del primo triangolo");
		int dueArea = due.altezza*due.larghezza;
		System.out.println(dueArea + " è l'area del primo triangolo");
		int duePerimetro = (due.altezza*2)+(due.larghezza*2);
		System.out.println(duePerimetro + " è il perimetro del primo triangolo");
		int perimetroTot = unoPerimetro + duePerimetro;
		int areaTot = unoArea + dueArea;
		System.out.println("Perimetro tot: " + perimetroTot);
		System.out.println("Area tot: " + areaTot);

	}
}
