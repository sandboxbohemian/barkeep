package com.motashishu.barkeep.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motashishu.barkeep.dao.CocktailRepository;
import com.motashishu.barkeep.model.Cocktails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CocktailService {
	
	@Autowired
	private InventoryService inventory;
	
	@Autowired
	private CocktailRepository cocktailDao;

	public Flux<String> getDrinks() {
		return cocktailDao.findAll()
				.map(Cocktails::getName);
	}

	public Flux<String> getPossibleDrinks() {
		return inventory.getAvailable()
				.collectList()
				.flatMapMany(t -> {
					return cocktailDao.findBy(t);
				})
				.map(Cocktails::getName);
	}

	public Mono<Cocktails> getRecipe(String drink) {
		return cocktailDao.findByName(drink);
	}

	public Flux<String> getDrinksByTheme(List<String> themes) {
		return cocktailDao.findByThemesIn(themes)
				.map(Cocktails::getName);
	}

	public Mono<String> getRandomDrink() {
		return cocktailDao.findRandomCocktail()
				.map(Cocktails::getName);
	}

	public Mono<String> getRandomDrink(String liquor) {
		return cocktailDao.findRandomCocktail(liquor)
				.map(Cocktails::getName);
	}

}
