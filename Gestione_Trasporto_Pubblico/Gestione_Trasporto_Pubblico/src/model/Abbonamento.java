package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import enums.TipologiaAbbonamento;


@Entity
// previene che ci siano duplicati nella colonna tessere
@Table(uniqueConstraints={@UniqueConstraint(name="myconst", columnNames={"tessera_id"})})
public class Abbonamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAbbonamento;
	
	@Column(name = "tipologia" ,nullable = false)
	@Enumerated(EnumType.STRING)
	private TipologiaAbbonamento tipologiaAbbonamento;
	
	@Column(name = "data_emissione", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissione;
	
	@Column(name = "data_scadenza", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataScadenza;
	
	@OneToOne
	private Tessera tessera;
	
	@ManyToOne
	private Tratta tratta;
	
	@ManyToOne
	private PuntoRilascio puntoRilascio;

	public Abbonamento() {
		super();
		
	}
	
	

	public Abbonamento(TipologiaAbbonamento tipologiaAbbonamento, Date dataEmissione, Date dataScadenza,
			Tessera tessera, Tratta tratta, PuntoRilascio puntoRilascio) {
		super();
		this.tipologiaAbbonamento = tipologiaAbbonamento;
		this.dataEmissione = dataEmissione;
		this.dataScadenza = dataScadenza;
		this.tessera = tessera;
		this.tratta = tratta;
		this.puntoRilascio = puntoRilascio;
	}



	public TipologiaAbbonamento getTipologiaAbbonamento() {
		return tipologiaAbbonamento;
	}

	public void setTipologiaAbbonamento(TipologiaAbbonamento tipologiaAbbonamento) {
		this.tipologiaAbbonamento = tipologiaAbbonamento;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public PuntoRilascio getPuntoRilascio() {
		return puntoRilascio;
	}

	public void setPuntoRilascio(PuntoRilascio puntoRilascio) {
		this.puntoRilascio = puntoRilascio;
	}

	public long getIdAbbonamento() {
		return idAbbonamento;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) throws Exception {
		if(this.dataEmissione == null || this.dataScadenza.before(this.dataEmissione)) throw new Exception();
		this.dataScadenza = dataScadenza;
	}



	@Override
	public String toString() {
		return "Abbonamento [idAbbonamento=" + idAbbonamento + ", tipologiaAbbonamento=" + tipologiaAbbonamento
				+ ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza + ", vidimazione="
				+ ", tessera=" + tessera + "]";
	}
	
	
	
}
