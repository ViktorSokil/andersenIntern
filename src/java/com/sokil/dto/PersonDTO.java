package com.sokil.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PersonDTO {
	//id will be used for storing MongoDB _id
	@Id
	private String id;
	
	private String name;
	private String address;
}
