package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tratta implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTratta;
	
	
	@Column(nullable = false, name = "partenza")
	private String nomeLocalitaPartenza;
	
	@Column(nullable = false, name = "arrivo")
	private String nomeLocalitaArrivo;
	
	@Column(nullable = false, name = "tempo_medio")
	private double tempoMedioPercorrenza;
	
	@OneToMany(mappedBy = "tratta", cascade = CascadeType.ALL)
	private List<Percorso> percorsi;
	
	@OneToMany(mappedBy = "tratta")
	private List<Abbonamento> abbonamenti;

	public Tratta() {
		super();
		
	}
	
	

	public Tratta(String nomeLocalitaPartenza, String nomeLocalitaArrivo, double tempoMedioPercorrenza) throws Exception {
		super();
		this.nomeLocalitaPartenza = nomeLocalitaPartenza;
		this.nomeLocalitaArrivo = nomeLocalitaArrivo;
		this.setTempoMedioPercorrenza(tempoMedioPercorrenza);
	}



	public String getNomeLocalitaPartenza() {
		return nomeLocalitaPartenza;
	}

	public void setNomeLocalitaPartenza(String nomeLocalitaPartenza) {
		this.nomeLocalitaPartenza = nomeLocalitaPartenza;
	}

	public String getNomeLocalitaArrivo() {
		return nomeLocalitaArrivo;
	}

	public void setNomeLocalitaArrivo(String nomeLocalitaArrivo) {
		this.nomeLocalitaArrivo = nomeLocalitaArrivo;
	}

	public double getTempoMedioPercorrenza() {
		return tempoMedioPercorrenza;
	}

	public void setTempoMedioPercorrenza(double tempoMedioPercorrenza) throws Exception {
		if(this.tempoMedioPercorrenza < 0) throw new Exception("setTempoMedioPercorrenza tratta");
		this.tempoMedioPercorrenza = tempoMedioPercorrenza;
	}

	public List<Percorso> getPercorsi() {
		return percorsi;
	}

	public void setPercorsi(List<Percorso> percorsi) {
		this.percorsi = percorsi;
	}

	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}

	public long getIdTratta() {
		return idTratta;
	}

	@Override
	public String toString() {
		return "Tratta [idTratta=" + idTratta + ", nomeLocalitaPartenza=" + nomeLocalitaPartenza
				+ ", nomeLocalitaArrivo=" + nomeLocalitaArrivo + ", tempoMedioPercorrenza=" + tempoMedioPercorrenza
				+ ", percorsi=" + percorsi + ", abbonamenti=" + abbonamenti + "]";
	}
	
	
	

}
