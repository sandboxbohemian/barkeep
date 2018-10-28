package com.motashishu.barkeep.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter @Setter @Builder
@SuppressWarnings("unused")
public class Cocktails {
	
	@Id
	private ObjectId _id;
	private String name;
	private List<String> liquor;
	@JsonView(Views.Recipe.class)
	private List<MeasuredIngredient> ingredients;
	@JsonView(Views.Recipe.class)
	private List<MeasuredIngredient> garnish;
	private List<String> themes;
	private String servingTemperature;
	@JsonView(Views.Recipe.class)
	private List<String> glassware;
	@JsonView(Views.Recipe.class)
	private String method;
	
	class MeasuredIngredient {
		private String name;
		private int portion;
		private String unit;
	}
}