package archivio;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@NamedQuery (name= "cercaAnno", query = "SELECT a FROM Catalogo a WHERE a.annoPubblicazione = :annopubblicazione")
@NamedQuery (name= "cercaPerTitolo", query = "SELECT a FROM Catalogo a WHERE a.titolo like :titolo")
public abstract class Catalogo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long isbncode;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private Integer annoPubblicazione;
	
	@Column(nullable = false)
	private Integer numeroPagine;
	
	
	public Catalogo() {
		super();
		
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}


	public void setAnnoPubblicazione(Integer date) {
		this.annoPubblicazione = date;
	}


	public Integer getNumeroPagine() {
		return numeroPagine;
	}


	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	
	//Utilizzo solo il Get, il set non lo utilizzo, perchè voglio sia generato automaticamente
	public long getIsbnCode() {
		return isbncode;
	}


	@Override
	public String toString() {
		return "Catalogo [isbnCode=" + isbncode + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
	
}