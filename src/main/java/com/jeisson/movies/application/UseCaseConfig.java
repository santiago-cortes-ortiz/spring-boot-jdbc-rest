package com.jeisson.movies.application;

import com.jeisson.movies.domain.model.movie.gateways.MovieRepository;
import com.jeisson.movies.domain.usecase.movie.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class UseCaseConfig {
    @Bean
    public MovieService movieService(MovieRepository movieRepository) {
        return new MovieService(movieRepository);
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

}
