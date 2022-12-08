package com.jeisson.movies.domain.model.movie.gateways;

import com.jeisson.movies.domain.model.movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);
}
