package com.jeisson.movies.domain.model.movie;

import com.jeisson.movies.domain.model.actor.Actor;

import java.time.LocalDate;
import java.util.List;

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    LocalDate releaseDate) {
}
