package com.sofka.exercise.java_backend.tournament.routes.team;

import com.sofka.exercise.java_backend.tournament.dto.TeamDTO;
import com.sofka.exercise.java_backend.tournament.usecases.team.GetTeamsByCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetTeamsByCountryRoute {

    @Bean
    public RouterFunction<ServerResponse> getTeamsByCountry(GetTeamsByCountryUseCase useCase) {
        return route(GET("/team/getByCountry/{country}")
                ,request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.apply(request.pathVariable("country")), TeamDTO.class))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }
}
