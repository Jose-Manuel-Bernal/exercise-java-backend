package com.sofka.exercise.java_backend.tournament.usecases.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.mapper.CyclistMapper;
import com.sofka.exercise.java_backend.tournament.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetCyclistsByCountryUseCase {
    private CyclistRepository repository;
    private CyclistMapper mapper;

    public GetCyclistsByCountryUseCase(CyclistRepository repository, CyclistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<CyclistDTO> apply(String country) {
        return repository.findByCountry(country)
                .map(cyclist -> mapper.toCyclistDTO(cyclist))
                .switchIfEmpty(Mono.error(() -> new Exception("No cyclists find with this country")));
    }
}
