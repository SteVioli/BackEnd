package CatalogoBibliotecario;

public class Libri extends CatalogoBibliotecario{
	private String autore;
	private String genere;
	public Libri(Integer codeIsbn, String titolo, Integer annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(codeIsbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	
	public Libri(Integer codeIsbn, String titolo, Integer annoPubblicazione, int numeroPagine, String autore) {
		super(codeIsbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
	}


	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public String toString() {
		return "Libro [autore: " + autore + ", genere: " + genere + ", codeIsbn: " + codeIsbn + ", titolo: " + titolo
				+ ", annoPubblicazione: " + annoPubblicazione + ", numeroPagine: " + numeroPagine + "]";
	}
	
	
	
	
	
	
}
