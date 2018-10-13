package com.motashishu.barkeep.dao;

import com.motashishu.barkeep.model.Cocktails;

import reactor.core.publisher.Mono;

public interface CocktailRepositoryCustom {

	public Mono<Cocktails> findRandomCocktail();
}
