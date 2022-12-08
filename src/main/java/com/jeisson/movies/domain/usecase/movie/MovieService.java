package com.jeisson.movies.domain.usecase.movie;

import com.jeisson.movies.domain.model.common.NotFoundException;
import com.jeisson.movies.domain.model.movie.Movie;
import com.jeisson.movies.domain.model.movie.gateways.MovieRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie> getMovies() {
        return movieRepository.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        // TODO: check if movie exists
        int result = movieRepository.insertMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void deleteMovie(Integer id) {
        Optional<Movie> movies = movieRepository.selectMovieById(id);
        movies.ifPresentOrElse(movie -> {
            int result = movieRepository.deleteMovie(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete movie");
            }
        }, () -> {
            throw new NotFoundException(String.format("Movie with id %s not found", id));
        });
    }

    public Movie getMovie(int id) {
        return movieRepository.selectMovieById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
    }
}
