package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoRilascio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPuntoRilascio;
	
	@Column(nullable = false, name = "localita")
	private String localita;
	
	@OneToMany(mappedBy = "puntoRilascio")
	private List<Biglietto> biglietti;
	
	@OneToMany(mappedBy = "puntoRilascio")
	private List<Abbonamento> abbonamenti;

	public PuntoRilascio() {
		super();
	}

	public PuntoRilascio(String localita) {
		super();
		this.localita = localita;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public List<Biglietto> getBiglietti() {
		return biglietti;
	}

	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}

	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}

	public long getIdPuntoRilascio() {
		return idPuntoRilascio;
	}

	@Override
	public String toString() {
		return "PuntoRilascio [idPuntoRilascio=" + idPuntoRilascio + ", localita=" + localita  + ", abbonamenti=" + abbonamenti + "]";
	}
	
	
}
