package br.com.alissondev.petStore.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pet-store")
public class Pet {
	
	@Id
	private ObjectId _id;
	private String breed;
	private String name;
	private String color;

}
