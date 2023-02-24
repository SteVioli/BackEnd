package model;

import javax.persistence.Entity;

@Entity
public class RivenditoreAutorizzato extends PuntoRilascio {
	private static final long serialVersionUID = 1L;

	public RivenditoreAutorizzato() {
		super();
		
	}

	public RivenditoreAutorizzato(String localita) {
		super(localita);	
	}

}
