package com.sofka.exercise.java_backend.tournament.usecases.team;

import com.sofka.exercise.java_backend.tournament.mapper.TeamMapper;
import com.sofka.exercise.java_backend.tournament.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteTeamUseCase {
    private TeamRepository repository;
    private TeamMapper mapper;

    public DeleteTeamUseCase(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<Void> apply(String id) {
        return repository.findById(id).switchIfEmpty(Mono.error(new IllegalStateException("The team doesn't exist")))
                .flatMap(team -> repository.deleteById(team.getId()));
    }
}
