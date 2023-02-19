package archivio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "trovaInPrestito" , query = "SELECT p FROM Prestito p INNER JOIN Utente u ON n_tessera = :numerotessera WHERE p.restituzioneEffettiva = null")
@NamedQuery(name = "trovaPrestitoScaduto" , query = "SELECT p FROM Prestito p WHERE p.restituzioneEffettiva != null AND (TO_DATE(p.restituzioneEffettiva,'dd-MM-yyyy') > TO_DATE(p.restituzionePrevista,'dd-MM-yyyy'))" )
//@NamedQuery(name = "notExpired" , query = "SELECT p FROM Prestito p WHERE p.restituzionePrevista > TO_CHAR(NOW():: DATE, 'DD-MM-YYYY');")

public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idprestito;
	@ManyToOne (cascade = CascadeType.ALL)//Molti prestiti sono associati ad uno specifico utente
	@JoinColumn(name="n_tessera")
	private Utente utente;
	
	@OneToOne (cascade = CascadeType.ALL)  //un prestito è associato all'id specifico del catalogo(libro o rivista)
	@JoinColumn (name="isbncode")
	
	private Catalogo elementoPrestato;
	
	@Column(nullable = false)
	private String inizioPrestito;
	
	@Column(nullable = false)
	private String restituzionePrevista;
	
	private String restituzioneEffettiva;

	


	public Prestito() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Prestito(Utente utente, Catalogo elementoPrestato) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
	}



	public Utente getUtente() {
		return utente;
	}



	public void setUtente(Utente utente) {
		this.utente = utente;
	}



	public Catalogo getElementoPrestato() {
		return elementoPrestato;
	}



	public void setElementoPrestato(Catalogo elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}



	public String getInizioPrestito() {
		return inizioPrestito;
	}



	public void setInizioPrestito(String inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}



	public String getRestituzionePrevista() {
		return restituzionePrevista;
	}



	public void setRestituzionePrevista(String restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista;
	}



	public String getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}



	public void setRestituzioneEffettiva(String restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}



	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", inizioPrestito="
				+ inizioPrestito + ", restituzionePrevista=" + restituzionePrevista + ", restituzioneEffettiva="
				+ restituzioneEffettiva + "]";
	}
	
	
	
	
}
