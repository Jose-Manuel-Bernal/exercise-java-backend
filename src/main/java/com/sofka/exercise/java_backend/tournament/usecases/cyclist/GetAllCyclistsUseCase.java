package com.sofka.exercise.java_backend.tournament.usecases.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.mapper.CyclistMapper;
import com.sofka.exercise.java_backend.tournament.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllCyclistsUseCase {

    private final CyclistRepository repository;
    private final CyclistMapper mapper;

    public GetAllCyclistsUseCase(CyclistRepository repository, CyclistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<CyclistDTO> apply() {
        return repository.findAll().map(cyclist -> mapper.toCyclistDTO(cyclist));
    }
}
