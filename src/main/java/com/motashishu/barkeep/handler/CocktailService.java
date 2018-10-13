package com.motashishu.barkeep.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motashishu.barkeep.dao.CocktailRepository;
import com.motashishu.barkeep.model.Cocktails;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
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
					System.out.println(t.toString());
					//String[] liqArr = t.toArray(new String[t.size()]);
					//System.out.println(liqArr);
					return cocktailDao.findBy(t);
				})
				.map(Cocktails::getName);
	}

	public Mono<String> getRandomDrink() {
		return cocktailDao.findRandomCocktail()
				.map(Cocktails::getName);
	}

}
