package menu.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationDrink {
	

	@Bean
	@Scope("singleton")
	public Drink cola() {
		return new Drink(3, "Bibita", "Coca-Cola", 80);
		
	}
	@Bean
	@Scope("singleton")
	public Drink acqua() {
		return new Drink(1.50, "Bibita", "Acqua", 0);
		
	}
	@Bean
	@Scope("singleton")
	public Drink birra() {
		return new Drink(4.5, "Bibita", "Birra", 100);
		
	}
	@Bean
	@Scope("singleton")
	public Drink amaro() {
		return new Drink(5, "Bibita", "Amaro", 150);
		
	}
}
