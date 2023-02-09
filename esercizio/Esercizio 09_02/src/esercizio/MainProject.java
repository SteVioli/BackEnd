package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	static Logger log = LoggerFactory.getLogger(MainProject.class);
	static Scanner sc = new Scanner(System.in);
	
	static List<Product> prodotti1 = new ArrayList<Product>();
	static List<Order> ordini1 = new ArrayList<Order>();
	
	public static void main(String[] args) {

		riempiLista();
		//prodotti1.forEach(ele -> log.info("Lista prodotti: " + ele));
		//lista effettivamente esistente
		
		//ESERCIZIO 1
		//filtraLibro();
		
		//ESERCIZIO 2
		//ordiniBaby();
		
		//ESERCIZIO 3
		//scontoBoys();
		
		//ESERCIZIO 4
		filtraPerData();
	}
	
	
	
	public static void filtraPerData() {
		List<Order> utenti = new ArrayList<Order>();
		utenti.add(new Order(1, "Finito", LocalDate.of(2021, 1, 12), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Stefano", 2)));
		utenti.add(new Order(2, "Finito", LocalDate.of(2021, 2, 12), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Fabio", 2)));
		utenti.add(new Order(3, "Rotto", LocalDate.of(2021, 3, 12), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Ali", 1)));
		utenti.add(new Order(4, "In Preparazione", LocalDate.of(2020, 4, 12), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Pippo", 2)));
		utenti.add(new Order(5, "Rotto", LocalDate.of(2021, 3, 1), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Luca", 2)));
		utenti.add(new Order(6, "Esaurito", LocalDate.of(2021, 3, 1), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Massimo", 1)));
		utenti.add(new Order(7, "Finito", LocalDate.of(2021, 2, 17), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Giulia", 1)));
		utenti.add(new Order(8, "Finito", LocalDate.of(2021, 2, 22), LocalDate.of(2020, 5, 12), prodotti1, new Customer(1, "Renata", 2)));
		System.out.println();
		
		List<Order> listaNuova = utenti.stream()
				.filter(ele -> ele.getCustomer().getTier() == 2)
				.filter(ele -> ele.getOrderDate().isAfter(LocalDate.of(2021,2,1)) && ele.getOrderDate().isBefore(LocalDate.of(2021,4,1)))
				.toList();
				System.out.println(listaNuova.size());
		for (int i = 0; i < listaNuova.size(); i++) {
			System.out.println(listaNuova.get(i).getProducts());
		}
	}
	
	public static void scontoBoys() {
		List<Product> boysSconto = prodotti1.stream()
				.filter(ele->ele.getCategory().equals("Boys"))
				.collect(Collectors.toList());
				
		for (int i = 0; i < boysSconto.size(); i++) {
			double a =	boysSconto.get(i).getPrice();
			boysSconto.get(i).setPrice(a*0.9);
			System.out.println(boysSconto.get(i));
		}
		
	
		
		
				
				
				
		
				
	}
	
 	public static void ordiniBaby() {
		Order ordiniBooks = new Order(1, "Free", LocalDate.of(2020, 1, 8),LocalDate.of(2020, 1, 12), prodotti1, new Customer(1, "Stefano", 2));
		
		Stream<Product> prodottiBooks = ordiniBooks.getProducts()
				.stream()
				.filter(ele -> ele.getCategory().equals("Baby"));
		prodottiBooks.forEach(ele-> System.out.println("Categoria Books: "+ele));
	}
	
	
	public static void filtraLibro() {
		Stream<Product> prova = prodotti1.stream()
				.filter(ele -> ele.getCategory().equals("Books"))
				.filter(ele -> ele.getPrice() >= 100);
		prova.forEach(ele-> System.out.println(ele));
		
	}
	
	public static void riempiLista() {
		prodotti1.add(new Product(1, "Java", "Books", 10.50));
		prodotti1.add(new Product(2, "Angular", "Books", 120.50));
		prodotti1.add(new Product(3, "Pippo", "Books", 101.50));
		prodotti1.add(new Product(4, "Scomodo", "Baby", 15.50));
		prodotti1.add(new Product(5, "JS", "Baby", 30.50));
		prodotti1.add(new Product(6, "HTML", "Baby", 70.50));
		prodotti1.add(new Product(7, "CSS", "Boys", 10.00));
		prodotti1.add(new Product(8, "BootStrap", "Boys", 20.00));
		prodotti1.add(new Product(9, "Pinocchio", "Boys", 30.00));
	}
}
