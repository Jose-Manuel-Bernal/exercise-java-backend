package com.sofka.exercise.java_backend.tournament.mapper;

import com.sofka.exercise.java_backend.tournament.dto.TeamDTO;
import com.sofka.exercise.java_backend.tournament.entity.Team;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class TeamMapper {

    private final ModelMapper modelMapper;

    public TeamMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TeamDTO toTeamDTO(Team team) {
        return modelMapper.map(team, TeamDTO.class);
    }

    public Team toTeamEntity(TeamDTO teamDTO) {
        return modelMapper.map(teamDTO, Team.class);
    }
}
