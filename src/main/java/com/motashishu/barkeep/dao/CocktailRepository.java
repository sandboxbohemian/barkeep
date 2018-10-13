package com.motashishu.barkeep.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.motashishu.barkeep.model.Cocktails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CocktailRepository extends ReactiveMongoRepository<Cocktails, ObjectId>, CocktailRepositoryCustom {

	public Mono<Cocktails> findByName(String name);
	public Flux<Cocktails> findByLiquor(String liquor);
	public Flux<Cocktails> findByThemesIn(List<String> theme);
	
	@Query("{liquor: {$not: {$elemMatch: {$nin: ?0}}}}")
	public Flux<Cocktails> findBy(List<String> liquor);
	
}
