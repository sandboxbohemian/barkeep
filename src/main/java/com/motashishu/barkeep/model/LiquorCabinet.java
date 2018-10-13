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
public class LiquorCabinet {

	@Id
	private ObjectId _id;
	private String uniqueToken;
	private List<String> collection;
}
