package com.sofka.exercise.java_backend.tournament.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

@Configuration
@EnableWebFlux
public class WebFluxConfig {
    @Bean
    public WebFluxConfigurer corsConfigure() {
        return new WebFluxConfigurerComposite() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") //IP
                        .allowedMethods("*"); //GET, POST, PUT , DELETE
            }
        };
    }
}
