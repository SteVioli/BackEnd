package menu.java;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import prodotti.java.Prodotti;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Pizza extends Prodotti{
	private List<String> ingrediente;
	private Integer calorie;
	public Pizza(double prezzo, String nomeOggetto) {
		super(prezzo, nomeOggetto);
		
		this.ingrediente = ingrediente;
	}
	
	public void baseMargherita() {
		this.ingrediente.add("mozzarella");
		this.ingrediente.add("pomodoro");
		this.prezzo = 5.00;
		this.calorie = 1000;
	}
	
	public void aggiungiProsciutto() {
		this.ingrediente.add("Prosciutto");
		this.prezzo += 1.50;
		this.calorie += 80;
	}
	public void aggiungiMelanzane() {
		this.ingrediente.add("Melanzane");
		this.prezzo += 1.10;
		this.calorie += 50;
	}
	public void aggiungiSalsiccia() {
		this.ingrediente.add("Salsiccia");
		this.prezzo += 1.00;
		this.calorie += 80;
	}
	public void aggiungiCipolla() {
		this.ingrediente.add("Cipolla");
		this.prezzo += 1.20;
		this.calorie += 40;
	}
	public void aggiungiFunghi() {
		this.ingrediente.add("Funghi");
		this.prezzo += 1.30;
		this.calorie += 50;
	}
	
	
	public String scontrino() {
		return "Ordine pizza: " + this.getNomeOggetto() + " prezzo: " + this.getPrezzo() + "€ con calorie: " + this.calorie + " ingrediente: " + this.ingrediente;
	}
}
