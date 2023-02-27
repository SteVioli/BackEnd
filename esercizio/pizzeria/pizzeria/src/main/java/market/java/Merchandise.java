package market.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import prodotti.java.Prodotti;


@ToString
@Getter
@Setter
public class Merchandise extends Prodotti {public Merchandise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Merchandise(double prezzo, String nomeOggetto) {
		super(prezzo, nomeOggetto);
		// TODO Auto-generated constructor stub
	}
	
	public String merchandiseScontrino() {
		return "MarketPlace: " + nomeOggetto + " costo: " + prezzo + "€";
 	}
}
