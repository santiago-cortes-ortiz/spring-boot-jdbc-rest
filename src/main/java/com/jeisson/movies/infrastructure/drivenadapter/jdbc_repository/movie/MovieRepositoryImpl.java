package com.jeisson.movies.infrastructure.drivenadapter.jdbc_repository.movie;

import com.jeisson.movies.domain.model.movie.Movie;
import com.jeisson.movies.domain.model.movie.gateways.MovieRepository;
import com.jeisson.movies.infrastructure.drivenadapter.jdbc_repository.helper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> selectMovies() {
        var sql = "SELECT * FROM movie LIMIT 100";
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        var sql = """
                INSERT INTO movie(name,release_date) VALUES(?,?)
                    """;
        return jdbcTemplate.update(
                sql,
                movie.name(), movie.releaseDate()
        );
    }

    @Override
    public int deleteMovie(int id) {
        var sql = "DELETE FROM movie WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = "SELECT * FROM movie WHERE id = ?";
<<<<<<< HEAD
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql,new MovieRowMapper(), id));
=======
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new MovieRowMapper(), id));
>>>>>>> d4641ecb26b2824725f9019d2ecdcabf251d2a2d
    }
}
