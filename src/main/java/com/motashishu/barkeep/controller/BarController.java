package com.motashishu.barkeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motashishu.barkeep.handler.CocktailService;
import com.motashishu.barkeep.handler.InventoryService;

import reactor.core.publisher.Mono;

@RestController
public class BarController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private CocktailService cocktailService;
	
	@GetMapping(path="bar/stock", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<List<String>> getInventory() {
		return inventoryService.getAvailable()
				.collectList();
	}
	
	@GetMapping(path="bar/stock/{liquor}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<Boolean> getInventory(@PathVariable String liquor) {
		return inventoryService.isAvailable();
	}
	
	@PostMapping(path="bar/stock", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> addToInventory(String liquor) {
		return inventoryService.add(liquor);
	}
	
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
	
}
