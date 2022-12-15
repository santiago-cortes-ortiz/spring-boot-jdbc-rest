package com.jeisson.movies.infrastructure.drivenadapter.jdbc_repository.helper;

import com.jeisson.movies.domain.model.movie.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                List.of(),
                resultSet.getDate("release_date").toLocalDate()
        );
    }

}
