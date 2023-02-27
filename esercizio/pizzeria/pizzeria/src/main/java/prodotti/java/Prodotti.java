package prodotti.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public abstract class Prodotti {
	protected double prezzo;
	protected String nomeOggetto;
}
