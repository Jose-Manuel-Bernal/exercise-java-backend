package com.sofka.exercise.java_backend.tournament.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "teams")
public class Team {

    @Id
    private String id;
    private String name;
    private String teamCode;
    private String country;
    private List<Cyclist> teamList;
}
