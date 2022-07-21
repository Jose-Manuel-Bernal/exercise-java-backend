package com.sofka.exercise.java_backend.tournament.usecases.team;

import com.sofka.exercise.java_backend.tournament.dto.TeamDTO;
import com.sofka.exercise.java_backend.tournament.mapper.TeamMapper;
import com.sofka.exercise.java_backend.tournament.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetTeamsByCountryUseCase {
    private TeamRepository repository;
    private TeamMapper mapper;

    public GetTeamsByCountryUseCase(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<TeamDTO> apply(String country) {
        return repository.findByCountry(country)
                .map(team -> mapper.toTeamDTO(team))
                .switchIfEmpty(Mono.error(() -> new Exception("No teams associated with this country")));
    }
}
