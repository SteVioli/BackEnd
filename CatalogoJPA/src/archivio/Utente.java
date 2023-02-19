package archivio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery (name= "cercaIdUtente", query = "SELECT u FROM Utente u WHERE u.numerotessera = :numerotessera")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numerotessera;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String Cognome;
	
	@Column(nullable = false)
	private Integer dataNascita;
	
	public Utente() {
		super();
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public Integer getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Integer dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	//Lasciato solo il get numero di tessera, perchè ho ragionato così:
	//Il numero di tessera non puoi modificarlo, ma può rimanere nel caso qualcun altro si cancelli e ne prenda la proprietà
	
	public long getNumeroTessera() {
		return numerotessera;
	}
	@Override
	public String toString() {
		return "Utente [numeroTessera=" + numerotessera + ", nome=" + nome + ", Cognome=" + Cognome + ", dataNascita="
				+ dataNascita + "]";
	}
	
	
}
