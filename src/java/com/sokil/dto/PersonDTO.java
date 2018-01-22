package com.sokil.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document(collection = PersonDTO.COLLECTION_NAME)
public class PersonDTO {
	public static final String COLLECTION_NAME = "persons";
	//id will be used for storing MongoDB _id
	@Id
	private Long id;
	
	private String name;
	private String address;
}
