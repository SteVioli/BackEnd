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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.ManutenzioneServizio;

@Entity
public class StatoMezzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStatoMezzo;
	
	@Column(nullable = false, name = "data_inizio")
	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	
	@Column(name = "data_fine")
	@Temporal(TemporalType.DATE)
	private Date dataFine;
	
	@Column(nullable = false, name = "stato")
	@Enumerated(EnumType.STRING)
	private ManutenzioneServizio manutenzioneServizio;
	
	@OneToOne
	private MezzoDiTrasporto mezzoDiTrasporto;

	public StatoMezzo() {
		super();
		
	}

	public StatoMezzo(Date dataInizio, ManutenzioneServizio manutenzioneServizio, MezzoDiTrasporto mezzoDiTrasporto) {
		super();
		this.dataInizio = dataInizio;
		this.manutenzioneServizio = manutenzioneServizio;
		this.mezzoDiTrasporto = mezzoDiTrasporto;
	}



	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) throws Exception {
		if(this.dataInizio.after(this.dataFine)) throw new Exception("setDataFine statoMezzo");
		this.dataFine = dataFine;	
	}

	public ManutenzioneServizio getStatoMezzo() {
		return manutenzioneServizio;
	}

	public void setStatoMezzo(ManutenzioneServizio statoMezzo) {
		this.manutenzioneServizio = statoMezzo;
	}

	public MezzoDiTrasporto getMezzoDiTrasporto() {
		return mezzoDiTrasporto;
	}

	public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
		this.mezzoDiTrasporto = mezzoDiTrasporto;
	}

	public long getIdStatoMezzo() {
		return idStatoMezzo;
	}

	@Override
	public String toString() {
		return "StatoMezzo [idStatoMezzo=" + idStatoMezzo + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ ", statoMezzo=" + manutenzioneServizio + ", mezzoDiTrasporto=" + mezzoDiTrasporto + "]";
	}	
	
}
