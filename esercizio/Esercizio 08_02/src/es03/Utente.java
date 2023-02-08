package es03;

public class Utente {
	private String nome;
	private String cognome;
	private String presenza;
	
	public Utente(String nome, String cognome, String presenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.presenza = presenza;
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

	public String getPresenza() {
		return presenza;
	}

	public void setPresenza(String presenza) {
		this.presenza = presenza;
	}

	@Override
	public String toString() {
		return "Utente [nome:" + nome + ", cognome:" + cognome + ", presenza:" + presenza + "]";
	}

	
	
}
