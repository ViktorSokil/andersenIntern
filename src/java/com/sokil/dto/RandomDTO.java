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
@Document(collection = RandomDTO.COLLECTION_NAME)
public class RandomDTO {
    public static final String COLLECTION_NAME = "randoms";
    @Id
    private Long id;
    private String text;
}
