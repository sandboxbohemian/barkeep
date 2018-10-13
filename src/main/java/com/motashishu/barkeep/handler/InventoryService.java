package com.motashishu.barkeep.handler;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryService {
	
	public Mono<Boolean> isAvailable() {
		return Mono.just(false);
	}
	
	public Flux<String> getAvailable() {
		return Flux.just("vodka", "bourbon", "white rum", "tequila");
	}
	
	public Mono<String> add(String liquor) {
		return Mono.just(liquor);
	}

}
