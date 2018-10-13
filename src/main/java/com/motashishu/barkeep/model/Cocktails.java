package com.motashishu.barkeep.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private List<MeasuredIngredient> ingredients;
	private List<MeasuredIngredient> garnish;
	private List<String> themes;
	private String servingTemperature;
	private List<String> glassware;
	private String method;
	
	class MeasuredIngredient {
		private String name;
		private int portion;
		private String unit;
	}
}