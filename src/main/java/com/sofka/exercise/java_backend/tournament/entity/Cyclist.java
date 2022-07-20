package com.sofka.exercise.java_backend.tournament.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cyclists")
public class Cyclist {
    @Id
    private String id;
    private String name;
    private Integer number;
    private String country;
    private String teamCode;
}
