package com.sofka.exercise.java_backend.tournament.usecases.cyclist;

import com.sofka.exercise.java_backend.tournament.mapper.CyclistMapper;
import com.sofka.exercise.java_backend.tournament.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteCyclistUseCase {
    private CyclistRepository repository;
    private CyclistMapper mapper;

    public DeleteCyclistUseCase(CyclistRepository repository, CyclistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<Void> apply(String id) {
        return repository.findById(id).switchIfEmpty(Mono.error(new IllegalStateException("The cyclist doesn't exist")))
                .flatMap(cyclist -> repository.deleteById(cyclist.getId()));
    }
}
