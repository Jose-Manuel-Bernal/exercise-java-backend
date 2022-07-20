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
public class PostCyclistUseCase {
    private final CyclistRepository repository;
    private final CyclistMapper mapper;

    public PostCyclistUseCase(CyclistRepository repository, CyclistMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO) {
        Integer cyclistNumber = cyclistDTO.getNumber();
        return repository.existFromNumber(cyclistNumber).flatMap(aBoolean -> {
            if (aBoolean) {
                return Mono.error(() -> new Exception("the numbar has already been taken"));
            }
            return repository.save(mapper.toCyclistEntity(cyclistDTO)).map(cyclist -> mapper.toCyclistDTO(cyclist));
        });
    }

//    public Mono<CyclistDTO> checkNumber(CyclistDTO cyclistDTO) {
//        Integer cyclistNumber = cyclistDTO.getNumber();
//        return repository.existFromNumber(cyclistNumber).flatMap(aBoolean -> {
//            if (aBoolean) {
//                return Mono.error(() -> new Exception("the numbar has already been taken"));
//            }
//            return repository.save(mapper.toCyclistEntity(cyclistDTO)).map(cyclist -> mapper.toCyclistDTO(cyclist));
//        });
//    }
}
