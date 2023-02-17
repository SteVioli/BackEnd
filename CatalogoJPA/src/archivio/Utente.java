package archivio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="n_tessera")
	private long numeroTessera;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String Cognome;
	
	@Column(nullable = false)
	private Date dataNascita;
	
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	//Lasciato solo il get numero di tessera, perchè ho ragionato così:
	//Il numero di tessera non puoi modificarlo, ma può rimanere nel caso qualcun altro si cancelli e ne prenda la proprietà
	
	public long getNumeroTessera() {
		return numeroTessera;
	}
	@Override
	public String toString() {
		return "Utente [numeroTessera=" + numeroTessera + ", nome=" + nome + ", Cognome=" + Cognome + ", dataNascita="
				+ dataNascita + "]";
	}
	
	
}
