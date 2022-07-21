package com.sofka.exercise.java_backend.tournament.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TeamDTO {

    private String id;
    @NotBlank(message = "team's name cannot be empty")
    private String name;
    @NotBlank(message = "teamCode cannot be empty")
    @Size(max = 3)
    private String teamCode;
    @NotBlank(message = "team's country cannot be empty")
    private String country;
    @Max(8)
    private Integer numberOfMembers;
}
