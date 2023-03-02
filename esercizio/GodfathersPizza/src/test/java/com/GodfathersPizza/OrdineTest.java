package com.GodfathersPizza;

import static org.junit.Assert.*;

import org.junit.Test;

import com.GodfathersPizza.model.Ordine;
import com.GodfathersPizza.model.PizzaMargherita;
import com.GodfathersPizza.model.StatoOrdine;
import com.GodfathersPizza.model.Tavolo;
import com.GodfathersPizza.model.Water;

public class OrdineTest {

	@Test
	public void addProdottoOrdine() {
		Tavolo t = new Tavolo(1,10,true);
		Ordine o = new Ordine();
		o.setTavolo(t);
		o.setNumeroOrdine(1);
		o.setNumeroCoperti(4);
		o.setStato(StatoOrdine.IN_CORSO);
		PizzaMargherita pizzaM = new PizzaMargherita();
		o.addProdotto(pizzaM);
		o.addProdotto(new Water());
		
		assertTrue(o.getOrdinato().contains(pizzaM));	
	}

}
