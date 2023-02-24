package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(name="myconst", columnNames={"utente_id"})})
public class Tessera implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTessera;
	
	@Column(nullable = false, name = "codice_tessera")
	private String codiceTessera;
	
	@Column(nullable = false , name = "data_emissione")
	@Temporal(TemporalType.DATE)
	private Date dataEmissione;
	
	@Column(nullable = false, name = "data_scadenza")
	@Temporal(TemporalType.DATE)
	private Date dataScadenza;
	
	@OneToOne
	private Utente utente;
	
	@OneToOne(mappedBy = "tessera")
	private Abbonamento abbonamento;
	

	public Tessera() {
		super();
	}

	public Tessera(String codiceTessera, Date dataEmissione, Utente utente) {
		super();
		this.codiceTessera = codiceTessera;
		this.dataEmissione = dataEmissione;
		this.utente = utente;
		this.setDataScadenza(dataEmissione);
	}



	public String getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(String codiceTessera) {
		this.codiceTessera = codiceTessera;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public long getIdTessera() {
		return idTessera;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	@SuppressWarnings("deprecation")
	public void setDataScadenza(Date d) {
		this.dataScadenza = (Date) d.clone();
		this.dataScadenza.setYear(this.dataScadenza.getYear()+1);
	}

	@Override
	public String toString() {
		return "Tessera [idTessera=" + idTessera + ", codiceTessera=" + codiceTessera + ", dataEmissione="
				+ dataEmissione + ", dataScadenza=" + dataScadenza + "]";
	}
	
	
}
