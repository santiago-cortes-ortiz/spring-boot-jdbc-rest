package com.jeisson.movies.infrastructure.entrypoint;

import com.jeisson.movies.domain.model.common.ResponseData;
import com.jeisson.movies.domain.model.movie.Movie;
import com.jeisson.movies.domain.usecase.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    private final Clock clock;

    @GetMapping
    public ResponseEntity<ResponseData> listMovies() {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .timestamp(LocalDateTime.now(clock))
                        .status(HttpStatus.OK.toString())
                        .statusCode(HttpStatus.OK.value())
                        .message("Movies listed successfully")
                        .data(Map.of(
                                "movies", movieService.getMovies()
                        ))
                        .build()
        );
    }

    @GetMapping("{id}")
    public Movie getMovieId(@PathVariable("id") Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteMovie(id);
    }

}

