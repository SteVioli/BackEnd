package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evento")
	private Integer idEvento;

	@Column(name="data_evento")
	private String dataEvento;

	@Column(name="descrizione_evento")
	private String descrizioneEvento;

	@Column(name="maxppl_evento")
	private Integer maxpplEvento;

	@Column(name="tipo_evento")
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;

	@Column(name="titolo_evento")
	
	private String titoloEvento;

	public Evento() {
	}

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getDataEvento() {
		return this.dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizioneEvento() {
		return this.descrizioneEvento;
	}

	public void setDescrizioneEvento(String descrizioneEvento) {
		this.descrizioneEvento = descrizioneEvento;
	}

	public Integer getMaxpplEvento() {
		return this.maxpplEvento;
	}

	public void setMaxpplEvento(Integer maxpplEvento) {
		this.maxpplEvento = maxpplEvento;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getTitoloEvento() {
		return this.titoloEvento;
	}

	public void setTitoloEvento(String titoloEvento) {
		this.titoloEvento = titoloEvento;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", dataEvento=" + dataEvento + ", descrizioneEvento="
				+ descrizioneEvento + ", maxpplEvento=" + maxpplEvento + ", tipoEvento=" + tipoEvento
				+ ", titoloEvento=" + titoloEvento + "]";
	}

	
}