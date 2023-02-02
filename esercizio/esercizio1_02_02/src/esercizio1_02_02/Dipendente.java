package esercizio1_02_02;

public class Dipendente {
	static private int stipendioBase = 1000;
	private int matricola;
	private int stipendio;
	private int importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	//COSTRUTTORE 1
	public Dipendente(int matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}
	
	//COSTRUTTORE 2
	public Dipendente(int stipendioBase, int matricola, int stipendio, 	int importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		super();
		this.stipendioBase = stipendioBase;
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	
	
	//GET AND SET
	public int getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(int importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	
	//SOLO GET
	
	public int getStipendioBase() {
		return stipendioBase;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public int getStipendio(Dipendente dipendente) {
		return dipendente.stipendio;
	}
	
	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDatiDipendente(Dipendente dipendente) {
		aggiornaStipendio(dipendente);
		//questo aggiorna stipendio messo dentro la stampa
		System.out.println(dipendente.toString());
	}
	
	public void promuovi(Dipendente dipendente) {
		if(dipendente.livello == Livello.OPERAIO) {
			dipendente.livello =Livello.IMPIEGATO;
		}else if(dipendente.livello == Livello.IMPIEGATO) {
			dipendente.livello = Livello.QUADRO;
		}else if(dipendente.livello == Livello.QUADRO) {
			dipendente.livello = Livello.DIRIGENTE;
		}else if(dipendente.livello == Livello.DIRIGENTE){
			System.out.println("Errore, impossibile aumentare il livello");
		}
	}
	public void aggiornaStipendio(Dipendente dipendente) {
		
		if(dipendente.livello == Livello.IMPIEGATO) {
			dipendente.stipendio = (int) (dipendente.stipendio * 1.2);
			if(dipendente.stipendio >= 2000) {
				dipendente.stipendio = 2000;
			}
			
		}else if (dipendente.livello == Livello.QUADRO) {
			dipendente.stipendio = (int) (dipendente.stipendio * 1.5);
			if(dipendente.stipendio >= 2500) {
				dipendente.stipendio = 2500;
			}
		}else if(dipendente.livello == Livello.DIRIGENTE) {
			dipendente.stipendio = (int) (dipendente.stipendio * 2);
			if(dipendente.stipendio < 2700) {
				dipendente.stipendio = 2700;
			}
			}
	}
	
	public static int calcolaPagaTotale(Dipendente dipendente, int ore) {
		if(dipendente.livello == Livello.OPERAIO) {
			if(dipendente.stipendio < 1000 || dipendente.stipendio > 1500) {
				dipendente.stipendio = 1000;
			}
		}else if(dipendente.livello == Livello.IMPIEGATO) {
			if(dipendente.stipendio < 1500 || dipendente.stipendio > 2000) {
				dipendente.stipendio = 1500;
			}
		}else if(dipendente.livello == Livello.QUADRO) {
			if(dipendente.stipendio < 2000 || dipendente.stipendio > 2500) {
				dipendente.stipendio = 2000;
			}
		}else if(dipendente.livello == Livello.DIRIGENTE) {
			if(dipendente.stipendio < 2500) {
				dipendente.stipendio = 2500;
			}
		}
		 int oreStrao = ore* dipendente.importoOrarioStraordinario;
		 int tot = dipendente.stipendio + oreStrao;
		 System.out.println("stipendio totale: " + tot);
		return tot;
	}
	
	
	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", stipendio=" + stipendio + ", importoOrarioStraordinario="
				+ importoOrarioStraordinario + ", livello=" + livello + ", dipartimento=" + dipartimento + "]";
	}
	
	
	
}
