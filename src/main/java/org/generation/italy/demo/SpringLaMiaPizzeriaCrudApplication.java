package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.DrinkService;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DrinkService drinkService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Margherita", "la classica, la migliore" , 10);
		Pizza p2 = new Pizza("Capricciosa", "Smettila di piangere" , 14);
		Pizza p3 = new Pizza("Special1", "la special degli specials" , 20);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		
		Drink d1 = new Drink("Coca Cola", "la classica, la migliore" , 2);
		Drink d2 = new Drink("Fanta", "Aranciata, arancione, gialla? Che buona!" , 1);
		Drink d3 = new Drink("Sprite", "Frizzantina, una punta di limone, la gassosa!" , 5);
		
		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
	}

}
