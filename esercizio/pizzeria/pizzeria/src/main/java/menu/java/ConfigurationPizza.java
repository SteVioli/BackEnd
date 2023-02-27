package menu.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class ConfigurationPizza {
	
	@Bean
	@Scope("prototype")
	public Pizza pizza(String nome,double prezzo) {
		return new Pizza(prezzo, nome);
		
	};
}
