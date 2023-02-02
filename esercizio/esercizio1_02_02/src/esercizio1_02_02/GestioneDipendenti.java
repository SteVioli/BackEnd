package esercizio1_02_02;

public class GestioneDipendenti {

	public static void main(String[] args) {
				
		///////////////////////////////////////////////	
		///////////////////////////////////////////////	
		////////ESERCIZIO 2 CON TEST///////////////////	
		
		/*Dipendente stefano = new Dipendente(1000, 1, 1000, 5, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente giulio = new Dipendente(1000, 2, 1200, 5, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente fabio = new Dipendente(1000, 3, 1600, 5, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente marco = new Dipendente(1000, 4, 2000, 5,Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		Dipendente[] azienda = new Dipendente[4];
		azienda[0] = stefano;
		azienda[1] = giulio;
		azienda[2] = fabio;
		azienda[3] = marco;
		
		for (int i = 0; i < azienda.length; i++) {
			
			if(azienda[i].getLivello() == Livello.IMPIEGATO) {
				Dipendente dip = (Dipendente) azienda[i];
				dip.promuovi(dip);
				dip.aggiornaStipendio(dip);
				System.out.println(dip);
			}else if (azienda[i].getLivello() == Livello.OPERAIO) {
				Dipendente dip = (Dipendente) azienda[0];
				Dipendente dip2 = (Dipendente) azienda[i];
				dip.promuovi(dip);
				dip.aggiornaStipendio(dip);
				System.out.println(azienda[i]);
				
			}
			
			System.out.println(azienda[i]);
		}
		
		double stipendioMensile = 0;
		for (int i = 0; i < azienda.length; i++) {
			stipendioMensile += Dipendente.calcolaPagaTotale(azienda[i], 5);	
		}
		
		System.out.println("Paga complessiva aziendale: " + stipendioMensile);
		*/
		
		///////////////////////////////////////////////	
		///////////////////////////////////////////////	
        ////////ESERCIZIO 1 CON TEST///////////////////	
		
		Dipendente a = new Dipendente(012345, Dipartimento.PRODUZIONE);
		
		System.out.println(a.getStipendio(a));
		System.out.println(a.calcolaPagaTotale(a,10));
		a.stampaDatiDipendente(a);
		System.out.println("----------------");
		a.promuovi(a);
		System.out.println(a.getStipendio(a));
		System.out.println(a.calcolaPagaTotale(a,10));
		a.stampaDatiDipendente(a);
		System.out.println("----------------");
		a.promuovi(a);
		System.out.println(a.getStipendio(a));
		System.out.println(a.calcolaPagaTotale(a,10));
		a.stampaDatiDipendente(a);
		System.out.println("----------------");
		a.promuovi(a);
		System.out.println(a.getStipendio(a));
		System.out.println(a.calcolaPagaTotale(a,10));
		a.stampaDatiDipendente(a);
		System.out.println("----------------");
		a.promuovi(a);
		System.out.println(a.getStipendio(a));
		System.out.println(a.calcolaPagaTotale(a,10));
		a.stampaDatiDipendente(a);
		System.out.println("----------------");
		System.out.println("----------------");
		
	
		Dipendente b = new Dipendente(1000, 2555, 1300, 0, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		
		
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println(b.getStipendio(b));
		System.out.println(b.calcolaPagaTotale(b,5));
		b.stampaDatiDipendente(b);
		System.out.println("----------------");
		b.promuovi(b);
		System.out.println(b.getStipendio(b));
		System.out.println(b.calcolaPagaTotale(b,5));
		b.stampaDatiDipendente(b);
		System.out.println("----------------");
		b.promuovi(b);
		System.out.println(b.getStipendio(b));
		System.out.println(b.calcolaPagaTotale(b,5));
		System.out.println("----------------");
		b.stampaDatiDipendente(b);
		b.promuovi(b);
		System.out.println(b.getStipendio(b));
		System.out.println(b.calcolaPagaTotale(b,5));
		b.stampaDatiDipendente(b);
		System.out.println("----------------");
		b.promuovi(b);
		System.out.println(b.getStipendio(b));
		System.out.println(b.calcolaPagaTotale(b,5));
		b.stampaDatiDipendente(b);
	}
	
}
