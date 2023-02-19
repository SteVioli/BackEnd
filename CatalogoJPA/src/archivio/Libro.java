package archivio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQuery (name= "cercaId", query = "SELECT a FROM Catalogo a WHERE a.isbncode = :isbncode")
@NamedQuery (name= "cercaAutore", query = "SELECT a FROM Catalogo a WHERE a.autore = :autore")

public class Libro extends Catalogo {
	
	//@Column(nullable = false)
	private String autore;
	
	//@Column(nullable = false)
	private String genere;
	
	public Libro() {
		super();
		
	}
	
	//GETTER AND SETTER TOTALI
	
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + "]";
	}
	
	
}
