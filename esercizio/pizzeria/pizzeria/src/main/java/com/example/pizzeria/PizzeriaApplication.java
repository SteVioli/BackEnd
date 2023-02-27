package com.example.pizzeria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import market.java.ConfigurationMerchandise;
import market.java.Merchandise;
import menu.java.ConfigurationDrink;
import menu.java.ConfigurationPizza;
import menu.java.Drink;
import menu.java.Pizza;

@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
		beanPizza();
		beanDrink();
		beanMerch();
	}
	
	
	public static void beanPizza() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationPizza.class);
		List<String> ingredienti = new ArrayList<String>();
		Pizza p1 = (Pizza) appCtx.getBean("pizza","Cipolla",0.00);
		p1.setIngrediente(ingredienti);
		p1.baseMargherita();
		p1.aggiungiCipolla();
		
		System.out.println(p1.scontrino());
		
		((AnnotationConfigApplicationContext) appCtx).close();
	}
	
	public static void beanDrink() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationDrink.class);
		Drink d1 = (Drink) appCtx.getBean("cola");
		System.out.println(d1.drinkScontrino());
		
		((AnnotationConfigApplicationContext) appCtx).close();
	}
	
	public static void beanMerch() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigurationMerchandise.class);
		Merchandise m1 = (Merchandise) appCtx.getBean("felpa");
		System.out.println(m1.merchandiseScontrino());

	}
}
