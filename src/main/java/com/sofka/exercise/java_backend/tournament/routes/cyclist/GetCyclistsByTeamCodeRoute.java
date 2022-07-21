package com.sofka.exercise.java_backend.tournament.routes.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.usecases.cyclist.GetCyclistsByTeamCodeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistsByTeamCodeRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclistsByTeamCode(GetCyclistsByTeamCodeUseCase useCase) {
        return route(GET("/cyclist/getByTeamCode/{code}")
                ,request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(useCase.apply(request.pathVariable("code")), CyclistDTO.class))
                .onErrorResume(throwable -> ServerResponse.notFound().build())
        );
    }
}
