package com.mamabologtub.graphql_tutorial.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Movie(Integer id, String title, Integer duration, Integer directorId) {
    public static List<Movie> movies = Arrays.asList(
        new Movie(1, "The Shawshank Redenption", 142, 11),
        new Movie(2, "The Dark Knight", 152, 22),
        new Movie(3, "Inception", 148, 22),
        new Movie(4, "The Matrix", 136, 33)
    );

    public static Optional<Movie> getMovieById(Integer id) {
        return movies.stream()
            .filter(m -> m.id.equals(id))
            .findFirst();
    }
}
