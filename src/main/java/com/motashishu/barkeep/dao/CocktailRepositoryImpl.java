package com.motashishu.barkeep.dao;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.client.result.UpdateResult;
import com.motashishu.barkeep.model.Cocktails;

import reactor.core.publisher.Mono;

@Repository
@Transactional(readOnly = true)
public class CocktailRepositoryImpl implements CocktailRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Mono<UpdateResult> upsert(Query query, Update update) {
		return Mono.just(mongoTemplate.upsert(query, update, Cocktails.class));
	}

	@Override
	public Mono<Cocktails> findRandomCocktail() {
		return Mono.just(getRandom());
	}
	
	private Cocktails getRandom() {
		Aggregation randomize = newAggregation(
				sample(1));
		return mongoTemplate.aggregate(randomize, Cocktails.class, Cocktails.class)
				.getMappedResults()
				.stream()
				.findAny()
				.get();
	}
}
