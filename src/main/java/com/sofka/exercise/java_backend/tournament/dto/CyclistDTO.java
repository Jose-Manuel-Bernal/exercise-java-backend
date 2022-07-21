package com.sofka.exercise.java_backend.tournament.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CyclistDTO {

    private String id;
    @NotBlank(message = "name cannot be empty")
    private String name;
    @Min(1)
    @Max(999)
    private Integer number;
    @NotBlank(message = "country cannot be empty")
    private String country;
    @NotBlank(message = "teamCode cannot be empty")
    @Size(max = 3)
    private String teamCode;
}
