package com.sofka.exercise.java_backend.tournament.usecases.team;

import com.sofka.exercise.java_backend.tournament.dto.TeamDTO;
import com.sofka.exercise.java_backend.tournament.mapper.TeamMapper;
import com.sofka.exercise.java_backend.tournament.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllTeamsUseCase {
    private TeamRepository repository;
    private TeamMapper mapper;

    public GetAllTeamsUseCase(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<TeamDTO> apply() {
        return repository.findAll().map(team -> mapper.toTeamDTO(team));
    }
}
