package com.sokil.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = Sequence.COLLECTION_NAME)
public class Sequence {
    public static final String COLLECTION_NAME = "sequences";

    @Id
    private String id;
    private Long sequence;
}
