package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import enums.TipologiaMezzi;

@Entity
public class MezzoDiTrasporto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMezzoDiTrasporto;
	
	@Column(nullable = false, name = "posti")
	private Integer numeroPosti;
	
	@Column(nullable = false, name = "tipologia")
	@Enumerated(EnumType.STRING)
	private TipologiaMezzi tipologiaMezzo;
	
	@OneToOne(mappedBy = "mezzoDiTrasporto", cascade = CascadeType.ALL)
	private StatoMezzo statoMezzo;
	
	@OneToMany(mappedBy = "parcoMezzi")
	private List<Biglietto> biglietti;
	
	@OneToMany(mappedBy = "mezzoDiTrasporto", cascade = CascadeType.ALL)
	private List<Percorso> percorsi;

	public MezzoDiTrasporto() {
		super();
		
	}
	
	public MezzoDiTrasporto(Integer numeroPosti, TipologiaMezzi tipologiaMezzo) {
		super();
		this.numeroPosti = numeroPosti;
		this.tipologiaMezzo = tipologiaMezzo;
		
	}



	public Integer getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public TipologiaMezzi getTipologiaMezzo() {
		return tipologiaMezzo;
	}

	public void setTipologiaMezzo(TipologiaMezzi tipologiaMezzo) {
		this.tipologiaMezzo = tipologiaMezzo;
	}

	public StatoMezzo getStatoMezzo() {
		return statoMezzo;
	}

	public void setStatoMezzo(StatoMezzo statoMezzo) {
		this.statoMezzo = statoMezzo;
	}

	public List<Biglietto> getBiglietti() {
		return biglietti;
	}

	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}

	public List<Percorso> getPercorsi() {
		return percorsi;
	}

	public void setPercorsi(List<Percorso> percorsi) {
		this.percorsi = percorsi;
	}

	public long getIdMezzoDiTrasporto() {
		return idMezzoDiTrasporto;
	}

	@Override
	public String toString() {
		return "MezzoDiTrasporto [idMezzoDiTrasporto=" + idMezzoDiTrasporto + ", numeroPosti=" + numeroPosti
				+ ", tipologiaMezzo=" + tipologiaMezzo + ", biglietti=" + biglietti + "]";
	}
		
}
