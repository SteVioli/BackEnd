package CatalogoBibliotecario;

public class Riviste extends CatalogoBibliotecario {
	private Periodicità periodicita;

	public Riviste(Integer codeIsbn, String titolo, Integer annoPubblicazione, int numeroPagine, Periodicità periodicita) {
		super(codeIsbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicità getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicità periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita: " + periodicita + ", codeIsbn: " + codeIsbn + ", titolo: " + titolo
				+ ", annoPubblicazione: " + annoPubblicazione + ", numeroPagine: " + numeroPagine + "]";
	}

	
	
}
