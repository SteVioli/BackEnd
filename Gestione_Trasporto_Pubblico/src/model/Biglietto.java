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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.TipologiaBiglietto;

@Entity
public class Biglietto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBiglietto;
	
	@Column(name = "tipologia", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipologiaBiglietto tipologiaBiglietto;
	
	@Column(name = "data_emissione", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissione;
	
	@Column(name = "data_scadenza", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataScadenza;
	
	@Column(name = "data_vidimazione")
	@Temporal(TemporalType.DATE)
	private Date vidimazione;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private MezzoDiTrasporto parcoMezzi;
	
	@ManyToOne
	private PuntoRilascio puntoRilascio;

	public Biglietto() {
		super();

	}
	
	

	public Biglietto(TipologiaBiglietto tipologiaBiglietto, Date dataEmissione, Date dataScadenza, Utente utente,
		 PuntoRilascio puntoRilascio) throws Exception {
		super();
		this.tipologiaBiglietto = tipologiaBiglietto;
		this.dataEmissione = dataEmissione;
		this.utente = utente;
		this.puntoRilascio = puntoRilascio;
		
		this.setDataScadenza(dataScadenza);
	}



	public MezzoDiTrasporto getParcoMezzi() {
		return parcoMezzi;
	}



	public void setParcoMezzi(MezzoDiTrasporto parcoMezzi) {
		if(this.vidimazione == null) {
			this.parcoMezzi = parcoMezzi;
		}
	}



	public TipologiaBiglietto getTipologiaBiglietto() {
		return tipologiaBiglietto;
	}

	public void setTipologiaBiglietto(TipologiaBiglietto tipologiaBiglietto) {
		this.tipologiaBiglietto = tipologiaBiglietto;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Date getVidimazione() {
		return vidimazione;
	}

	public void setVidimazione(Date vidimazione) throws Exception {
		if(this.vidimazione != null || this.dataScadenza.before(vidimazione)) throw new Exception("setVidimazione biglietto");
		this.vidimazione = vidimazione;			
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public PuntoRilascio getPuntoRilascio() {
		return puntoRilascio;
	}

	public void setPuntoRilascio(PuntoRilascio puntoRilascio) {
		this.puntoRilascio = puntoRilascio;
	}

	public long getIdBiglietto() {
		return idBiglietto;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) throws Exception {	
		if(this.dataEmissione == null || dataScadenza.before(this.dataEmissione)) throw new Exception("setDataScadenza biglietto");
		this.dataScadenza = dataScadenza;	
	}



	@Override
	public String toString() {
		return "Biglietto [idBiglietto=" + idBiglietto + ", tipologiaBiglietto=" + tipologiaBiglietto
				+ ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza + ", vidimazione=" + vidimazione
				+ ", utente=" + utente + ", parcoMezzi=" + parcoMezzi + ", puntoRilascio=" + puntoRilascio + "]";
	}	
}
