package com.motashishu.barkeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.motashishu.barkeep.handler.CocktailService;

import reactor.core.publisher.Mono;

@RestController
public class BarController {
	
	@Autowired
	private CocktailService cocktailService;
	
	@GetMapping(path="bar/menu", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<List<String>> getCocktailMenu() {
		return cocktailService.getDrinks()
				.collectList();
	}
	
	@GetMapping(path="bar/menu/available", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<List<String>> getAvailableCocktailMenu() {
		return cocktailService.getPossibleDrinks()
				.collectList();
	}
	
	@GetMapping(path="bar/menu/surpriseme", consumes=MediaType.TEXT_PLAIN_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public Mono<String> getRandomCocktail() {
		return cocktailService.getRandomDrink();
	}
	
	@GetMapping(path="bar/menu/themes", consumes=MediaType.TEXT_PLAIN_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public  Mono<List<String>> getCocktailsByTheme() {
		return cocktailService.getPossibleDrinks()
				.collectList();
	}
	
	@GetMapping(path="bar/recipe/{drink}", consumes=MediaType.TEXT_PLAIN_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public Mono<String> getRecipe(@PathVariable("drink") String drink) {
		return cocktailService.getRecipe(drink);
	}
	
}
