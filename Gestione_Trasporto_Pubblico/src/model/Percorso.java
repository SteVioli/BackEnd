package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Percorso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPercorso;
	
	@Column(name = "ora_inizio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date oraInizioTratta;
	
	@Column(nullable = false, name = "tempo_effetivo")
	private double tempoPercorso;
	
	@ManyToOne
	private MezzoDiTrasporto mezzoDiTrasporto;
	
	@ManyToOne
	private Tratta tratta;

	public Percorso() {
		super();
	}
	
	public Percorso(double tempoPercorso, MezzoDiTrasporto mezzoDiTrasporto, Tratta tratta, Date d) throws Exception {
		super();
		this.mezzoDiTrasporto = mezzoDiTrasporto;
		this.tratta = tratta;
		this.oraInizioTratta = d;
		this.setTempoPercorso(tempoPercorso);
	}

	public double getTempoPercorso() {
		return tempoPercorso;
	}

	public void setTempoPercorso(double tempoPercorso) throws Exception {
		if(tempoPercorso <= 0) throw new Exception("setTempoPercorso percorso");
		this.tempoPercorso = tempoPercorso;
	}

	public MezzoDiTrasporto getMezzoDiTrasporto() {
		return mezzoDiTrasporto;
	}

	public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
		this.mezzoDiTrasporto = mezzoDiTrasporto;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public long getIdPercorso() {
		return idPercorso;
	}

	public Date getOraInizioTratta() {
		return oraInizioTratta;
	}

	public void setOraInizioTratta(Date oraInizioTratta) {
		this.oraInizioTratta = oraInizioTratta;
	}

	@Override
	public String toString() {
		return "Percorso [idPercorso=" + idPercorso + ", oraInizioTratta=" + oraInizioTratta + ", tempoPercorso="
				+ tempoPercorso + ", mezzoDiTrasporto=" + mezzoDiTrasporto + ", tratta=" + tratta + "]";
	}
}
