package com.GodfathersPizza.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Ordine {
	
	private int numeroOrdine;
	private Tavolo tavolo;
	private List<Prodotto> ordinato = new ArrayList<Prodotto>();
	private StatoOrdine stato = StatoOrdine.IN_CORSO;
	private int numeroCoperti = 1;
	private LocalDateTime oraAcquisizione = LocalDateTime.now();
	
	@Value("${GodfathersPizza.costoCoperto}")
	private String costoCoperto;
	
	public void addProdotto(Prodotto p) {
		ordinato.add(p);
		
	}
	
	public void removeProdotto(Prodotto p) {
		if(ordinato.contains(p)) {
			ordinato.remove(p);
		} else {
			System.out.println("Nessun prodotto nel tuo ordine!!");
		}
	}
	
	public String calcolaTotaleOrdine() {
		return costoCoperto;
	}
	
}
