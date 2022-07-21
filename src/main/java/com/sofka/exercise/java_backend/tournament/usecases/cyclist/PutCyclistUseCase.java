package com.sofka.exercise.java_backend.tournament.usecases.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.mapper.CyclistMapper;
import com.sofka.exercise.java_backend.tournament.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PutCyclistUseCase {
    private CyclistRepository repository;
    private CyclistMapper mapper;

    public PutCyclistUseCase(CyclistRepository repository, CyclistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO) {
        Integer cyclistNum = cyclistDTO.getNumber();
        return repository.existsByNumber(cyclistNum).flatMap(aBoolean -> {
            if (Boolean.TRUE.equals(aBoolean)){
                return Mono.error(() -> new Exception("the number has already been taken"));
            }
            return repository.save(mapper.toCyclistEntity(cyclistDTO))
                    .map(cyclist -> mapper.toCyclistDTO(cyclist));
        });
    }
}
