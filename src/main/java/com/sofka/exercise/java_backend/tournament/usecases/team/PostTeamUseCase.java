package com.sofka.exercise.java_backend.tournament.usecases.team;

import com.sofka.exercise.java_backend.tournament.dto.TeamDTO;
import com.sofka.exercise.java_backend.tournament.mapper.TeamMapper;
import com.sofka.exercise.java_backend.tournament.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PostTeamUseCase {
    private TeamRepository repository;
    private TeamMapper mapper;

    public PostTeamUseCase(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<TeamDTO> apply(@Valid TeamDTO teamDTO) {
        return repository.save(mapper.toTeamEntity(teamDTO))
                .map(team -> mapper.toTeamDTO(team));
    }
}
