package com.sofka.exercise.java_backend.tournament.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CyclistDTO {

    private String id;
    @NotBlank(message = "name cannot be empty")
    private String name;
    @NotNull(message = "cyclist's number cannot be empty")
    @Digits(integer = 3, fraction = 0)
    @Max(999)
    @Min(1)
    private Integer number;
    @NotBlank(message = "country cannot be empty")
    private String country;
    @NotBlank(message = "teamCode cannot be empty")
    private String teamCode;
}
