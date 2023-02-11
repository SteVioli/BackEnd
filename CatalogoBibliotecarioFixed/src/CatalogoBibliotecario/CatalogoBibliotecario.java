package CatalogoBibliotecario;

abstract class CatalogoBibliotecario {
	protected Integer codeIsbn;
	protected String titolo;
	protected Integer annoPubblicazione;
	protected int numeroPagine;
	
	public CatalogoBibliotecario(Integer codeIsbn, String titolo, Integer annoPubblicazione, int numeroPagine) {
		super();
		this.codeIsbn = codeIsbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public Integer getCodeIsbn() {
		return codeIsbn;
	}


	public String getTitolo() {
		return titolo;
	}


	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	

	@Override
	public String toString() {
		return "CatalogoBibliotecario [codeIsbn=" + codeIsbn + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}

	
	
}
