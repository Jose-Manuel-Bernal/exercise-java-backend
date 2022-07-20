package com.sofka.exercise.java_backend.tournament.mapper;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.entity.Cyclist;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class CyclistMapper {

    private final ModelMapper modelMapper;

    public CyclistMapper (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CyclistDTO toCyclistDTO (Cyclist cyclist) {
        return modelMapper.map(cyclist, CyclistDTO.class);
    }

    public Cyclist toCyclistEntity (CyclistDTO cyclistDTO) {
        return modelMapper.map(cyclistDTO, Cyclist.class);
    }
}
