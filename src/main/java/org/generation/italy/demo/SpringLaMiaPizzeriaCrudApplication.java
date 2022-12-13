package org.generation.italy.demo;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promotion;
import org.generation.italy.demo.service.DrinkService;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromotionService;
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

	@Autowired
	private PromotionService promotionService;

	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Promotion pr1 = new Promotion(LocalDate.parse("2022-10-12"), LocalDate.parse("2022-11-12"), "Super sconto");
		Promotion pr2 = new Promotion(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-09"), "Inizio 2023");
		
		promotionService.save(pr1);
		promotionService.save(pr2);
		
		Pizza p1 = new Pizza("Margherita", "la classica, la migliore" , 10, pr1);
		Pizza p4 = new Pizza("Margheritona", "la classicone, la migliorona" , 20, pr1);
		Pizza p2 = new Pizza("Capricciosa", "Smettila di piangere" , 14, pr2);
		Pizza p3 = new Pizza("Special1", "la special degli specials" , 20, null);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		
		Drink d1 = new Drink("Coca Cola", "la classica, la migliore" , 2);
		Drink d2 = new Drink("Fanta", "Aranciata, arancione, gialla? Che buona!" , 1);
		Drink d3 = new Drink("Sprite", "Frizzantina, una punta di limone, la gassosa!" , 5);
		
		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		
		//----------DELETE-------------
		//promotionService.deletePromotionById(1);
		//pizzaService.deletePizzaById(1);
		
		System.out.println("---------------------------");
		List<Pizza> pizzas = pizzaService.findAll();
		for (Pizza pizza : pizzas) {
			System.err.println(pizza + "\n\t" + pizza.getPromotion());
		}
		
		System.out.println("---------------------------");
		List<Promotion> promotions = promotionService.findAllWPizza();
		
		for (Promotion promotion : promotions) {
			System.err.println(promotion);
			for (Pizza pizza : promotion.getPizzas()) {
				System.err.println("\t" + pizza);
			}
		}
	}

}
