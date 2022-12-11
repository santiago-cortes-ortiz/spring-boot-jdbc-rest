package com.jeisson.movies.infrastructure.drivenadapter.jdbc_repository.movie;

import com.jeisson.movies.domain.model.movie.Movie;
import com.jeisson.movies.domain.model.movie.gateways.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Override
    public List<Movie> selectMovies() {
        return null;
    }

    @Override
    public int insertMovie(Movie movie) {
        return 0;
    }

    @Override
    public int deleteMovie(int id) {
        return 0;
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        return Optional.empty();
    }
}
