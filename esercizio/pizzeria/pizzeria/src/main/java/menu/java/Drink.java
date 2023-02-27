package menu.java;

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
public class Drink extends Prodotti{
	private String nomeDrink;
	private Integer calorie;
	public Drink(double prezzo, String nomeOggetto, String nomeDrink, Integer calorie) {
		super(prezzo, nomeOggetto);
		this.nomeDrink = nomeDrink;
		this.calorie = calorie;
	}
	
	public String drinkScontrino() {
		return "Bevanda: " + this.nomeDrink + " calorie: " + this.calorie + " prezzo: " + this.prezzo +"€";
	}
	
}
