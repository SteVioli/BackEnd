package market.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import menu.java.Drink;

@Configuration
public class ConfigurationMerchandise {
	@Bean
	@Scope("singleton")
	public Merchandise felpa() {
		return new Merchandise(15.50, "Felpa Pizzeria");
		
	}
	@Bean
	@Scope("singleton")
	public Merchandise maglietta() {
		return new Merchandise(7.50, "Maglietta Pizzeria");
		
	}
	@Bean
	@Scope("singleton")
	public Merchandise cappello() {
		return new Merchandise(10.00, "Cappello Pizzeria");
		
	}
}
