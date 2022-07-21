package com.sofka.exercise.java_backend.tournament.usecases.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.entity.Team;
import com.sofka.exercise.java_backend.tournament.mapper.CyclistMapper;
import com.sofka.exercise.java_backend.tournament.mapper.TeamMapper;
import com.sofka.exercise.java_backend.tournament.repository.CyclistRepository;
import com.sofka.exercise.java_backend.tournament.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PostCyclistUseCase {
    private final CyclistRepository cyclistRepository;
    private final TeamRepository teamRepository;
    private final CyclistMapper cyclistMapper;


    public PostCyclistUseCase(CyclistRepository cyclistRepository, TeamRepository teamRepository, CyclistMapper cyclistMapper) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
        this.cyclistMapper = cyclistMapper;
    }

    public Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO) {
        Integer cyclistNum = cyclistDTO.getNumber();
        String teamCode = cyclistDTO.getTeamCode();
        return cyclistRepository.existsByNumber(cyclistNum).flatMap(aBoolean -> {
            if (Boolean.TRUE.equals(aBoolean)) {
                return Mono.error(() -> new Exception("the number has already been taken"));
            }
            return teamRepository.existsByTeamCode(teamCode).flatMap(aBoolean1 -> {
                if (Boolean.TRUE.equals(aBoolean1)) {
                    return teamRepository.findByTeamCode(teamCode)
                            .flatMap(team -> {
                                if (team.getNumberOfMembers() > 8) {
                                    return Mono.error(() -> new Exception("the team if full"));
                                }
                                return this.teamRepository.save(team.toBuilder()
                                                .numberOfMembers(team.getNumberOfMembers() + 1)
                                                .build())
                                        .flatMap(team1 -> cyclistRepository.save(cyclistMapper.toCyclistEntity(cyclistDTO))
                                                .map(cyclist -> cyclistMapper.toCyclistDTO(cyclist)));
                            });
                }
                return Mono.error(() -> new Exception("the team code does not exist"));
            });
        });
    }


}
