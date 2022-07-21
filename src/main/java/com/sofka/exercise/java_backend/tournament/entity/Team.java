package com.sofka.exercise.java_backend.tournament.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "teams")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    private String id;
    private String name;
    private String teamCode;
    private String country;
    private Integer numberOfMembers;
}
