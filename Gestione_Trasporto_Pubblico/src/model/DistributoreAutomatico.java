package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.StatoDistributoreAutomatico;

@Entity
public class DistributoreAutomatico extends PuntoRilascio {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, name = "stato_veicolo")
	@Enumerated(EnumType.STRING)
	private StatoDistributoreAutomatico statoDistributoreAutomatico;

	public DistributoreAutomatico() {
		super();
		
	}
	
	public DistributoreAutomatico(String localita, StatoDistributoreAutomatico statoDistributoreAutomatico) {
		super(localita);
		this.statoDistributoreAutomatico = statoDistributoreAutomatico;
		
	}

	public StatoDistributoreAutomatico getStatoDistributoreAutomatico() {
		return statoDistributoreAutomatico;
	}

	public void setStatoDistributoreAutomatico(StatoDistributoreAutomatico statoDistributoreAutomatico) {
		this.statoDistributoreAutomatico = statoDistributoreAutomatico;
	}

	@Override
	public String toString() {
		return "DistributoreAutomatico [statoDistributoreAutomatico=" + statoDistributoreAutomatico + ", "
				+ super.toString() + "]";
	}	
	
}
