package archivio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class Prestito {
	@Id
	@ManyToOne //Molti prestiti sono associati ad uno specifico utente
	@JoinColumn(name="n_tessera")
	
	private Utente utente;
	
	@OneToOne   //un prestito è associato all'id specifico del catalogo(libro o rivista)
	@JoinColumn (name="isbnCode")
	
	private Catalogo elementoPrestato;
	
	@Column(nullable = false)
	private Integer inizioPrestito;
	
	@Column(nullable = false)
	private Integer restituzionePrevista;
	
	@Column(nullable = false)
	private Integer restituzioneEffettiva;

	public Prestito() {
		super();
		
	}

	public Utente getUtente() {
		return utente;
	}

	public Catalogo getElementoPrestato() {
		return elementoPrestato;
	}

	public Integer getInizioPrestito() {
		return inizioPrestito;
	}

	public void setInizioPrestito(Integer inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}

	public Integer getRestituzionePrevista() {
		return restituzionePrevista;
	}

	public void setRestituzionePrevista(Integer restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista;
	}

	public Integer getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(Integer restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", inizioPrestito="
				+ inizioPrestito + ", restituzionePrevista=" + restituzionePrevista + ", restituzioneEffettiva="
				+ restituzioneEffettiva + "]";
	}
	
	
	
	
}
