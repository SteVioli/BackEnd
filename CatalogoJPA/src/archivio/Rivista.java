package archivio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends Catalogo {
	
	//@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	
	public Rivista() {
		super();

	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + "]";
	}
	
	
}
