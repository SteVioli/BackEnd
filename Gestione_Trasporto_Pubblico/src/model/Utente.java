package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Utente implements Serializable{
	private static final long serialVersionUID = 1L;
	private static String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUtente;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, name = "data_nascita")
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	
	@Column(nullable = false)
	private String localita;
	
	@OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
	private Tessera tessera;
	
	@OneToMany(mappedBy = "utente")
	private List<Biglietto> biglietto;
	
	public Utente() {
		super();
		
	}

	public Utente(String nome, String cognome, String email, Date dataDiNascita, String localita) throws Exception {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.localita = localita;
		this.setEmail(email);
		this.setDataDiNascita(dataDiNascita);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws Exception {
		if(!email.matches(regexPattern))throw new Exception("setEmail utente");
		this.email = email;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Date getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(Date dataDiNascita) throws Exception {
		if(this.dataDiNascita != null && this.dataDiNascita.after(new Date())) throw new Exception("setDataDiNascita utente");
		this.dataDiNascita = dataDiNascita;
	}


	public String getLocalita() {
		return localita;
	}


	public void setLocalita(String localita) {
		this.localita = localita;
	}


	public Tessera getTessera() {
		return tessera;
	}

	public long getIdUtente() {
		return idUtente;
	}


	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita="
				+ dataDiNascita + ", localita=" + localita + "]";
	}
	
	
	
}
