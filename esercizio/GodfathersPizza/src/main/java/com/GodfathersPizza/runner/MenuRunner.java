package com.GodfathersPizza.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.GodfathersPizza.configuration.MenuConfiguration;
import com.GodfathersPizza.model.Menu;
import com.GodfathersPizza.model.Ordine;
import com.GodfathersPizza.model.PizzaMargherita;
import com.GodfathersPizza.model.Tavolo;
import com.GodfathersPizza.model.Water;

@Component
public class MenuRunner implements CommandLineRunner {
	
	static Menu menu;
	static AnnotationConfigApplicationContext appCtx;

	@Override
	public void run(String... args) throws Exception {
		gestioneMenu();
		
		Tavolo t1 = creaTavolo(1, 4, false);
		Tavolo t2 = creaTavolo(2, 4, false);
		
		appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		PizzaMargherita pm = (PizzaMargherita) appCtx.getBean("pizzaMargherita");
		Water w = (Water) appCtx.getBean("water");
		
		
		Ordine o1 = creaOrdine(t1, 3);
		Ordine o2 = creaOrdine(t2, 4);
		
		o1.addProdotto(pm);
		o1.addProdotto(w);
		System.out.println(calcolaTotale(o1));
		
	}
	
	// Gestione Menu
	
	public void gestioneMenu() {
		appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
	
		// Recupero Bean
		menu = (Menu) appCtx.getBean("menu");
		stampaMenu();
		
		appCtx.close();
	}
	
	public void stampaMenu() {
		System.out.println("********** Menu **********");
		System.out.println("Pizzas");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuPizza()));
		
		System.out.println("Toppings");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuTopping()));
		
		System.out.println("Drinks");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuDrink()));
		
		System.out.println("Franchise");
		menu.getMenuBrand().forEach(a -> System.out.println(a.getMenuArticoloBrand()));
	}

	// Gestione Ordine
	
	public Ordine creaOrdine(Tavolo tavolo, int numCoperti) {
		appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		Ordine o = (Ordine) appCtx.getBean("ordine");
		o.setTavolo(tavolo);
		o.setNumeroCoperti(numCoperti);
		appCtx.close();
		return o;
	}
	
	public Tavolo creaTavolo(int tavolo, int numCoperti,boolean stato) {
		appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		Tavolo t = (Tavolo) appCtx.getBean("tavolo");
		t.setNumero(tavolo);
		t.setNumeroMassimoCoperti(numCoperti);
		t.setStato(stato);
		appCtx.close();
		return t;
	}

	public void stampaOrdine(Ordine o) {
		System.out.println(o.getOrdinato());
	}
	
	double prezzo = 0;
	double coperto;
	public double calcolaTotale(Ordine o) {
		o.getOrdinato().forEach(e-> prezzo += e.getPrezzo());
		coperto = Double.parseDouble(o.getCostoCoperto());
		return prezzo + ( coperto * o.getNumeroCoperti());
		
	}
	
	public void popolaOrdine(Ordine o) {
		// popola Ordine
		//o1.addProdotto(null)
	}

}
