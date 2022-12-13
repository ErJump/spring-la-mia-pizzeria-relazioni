package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Ingredient;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.IngredientService;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientService iS;
	
	@Autowired
	private PizzaService pS;
	
	@GetMapping
	public String index(Model model) {
		
		List<Ingredient> ingredients = iS.findAllWPizza();
		model.addAttribute("ingredients", ingredients);
		return "ingredient-index";
	}
	
	@GetMapping("/create")
	public String getIngredientCreate(Model model) {
		
		Ingredient i = new Ingredient();
		List<Pizza> pizzas = pS.findAll();
		model.addAttribute("ingredient", i);
		model.addAttribute("pizzas", pizzas);
		return "ingredient-create";
	}
}
