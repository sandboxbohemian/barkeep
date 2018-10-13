package com.motashishu.barkeep.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motashishu.barkeep.dao.CocktailRepository;
import com.motashishu.barkeep.model.Cocktails;

import reactor.core.publisher.Mono;

@Service
public class RecipeService {
	
	@Autowired
	private CocktailRepository recipeDao;
	
	public Mono<Cocktails> getRecipe(String cocktailName) {
		return recipeDao.findByName(cocktailName);
	}
	
	public Mono<Cocktails> addRecipe(Cocktails newRecipe) {
		// FIXME recipeDao.sa
		return null;
	}

}
