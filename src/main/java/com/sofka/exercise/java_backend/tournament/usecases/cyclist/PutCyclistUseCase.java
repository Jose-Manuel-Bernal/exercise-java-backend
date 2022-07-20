package com.sofka.exercise.java_backend.tournament.usecases.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.mapper.CyclistMapper;
import com.sofka.exercise.java_backend.tournament.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PutCyclistUseCase {
    private CyclistRepository repository;
    private CyclistMapper mapper;

    public PutCyclistUseCase(CyclistRepository repository, CyclistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<CyclistDTO> apply(CyclistDTO cyclistDTO) {
        return repository.save(mapper.toCyclistEntity(cyclistDTO)).map(cyclist -> mapper.toCyclistDTO(cyclist));
    }
}
