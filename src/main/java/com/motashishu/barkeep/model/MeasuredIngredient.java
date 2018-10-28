package com.motashishu.barkeep.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;

class MeasuredIngredient {
	@JsonView(Views.Recipe.class)
	private String name;
	@JsonView(Views.Recipe.class)
	private float portion;
	@JsonView(Views.Recipe.class)
	private Optional<String> unit;
}