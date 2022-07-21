package com.sofka.exercise.java_backend.tournament.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document(collection = "cyclists")
public class Cyclist {
    @Id
    private String id;
    //@NotBlank(message = "name cannot be empty")
    private String name;
    //@NotBlank(message = "cyclist's number cannot be empty")
    private Integer number;
    //@NotBlank(message = "country cannot be empty")
    private String country;
    //@NotBlank(message = "teamCode cannot be empty")
    //@Size(max = 3)
    private String teamCode;
}
