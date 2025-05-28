package com.mamabologtub.graphql_tutorial.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record MovieDto(Integer id, String title, Integer duration, Integer directorId) {
    public static List<MovieDto> movies = Arrays.asList(
        new MovieDto(1, "The Shawshank Redenption", 142, 11),
        new MovieDto(2, "The Dark Knight", 152, 22),
        new MovieDto(3, "Inception", 148, 22),
        new MovieDto(4, "The Matrix", 136, 33)
    );

    public static Optional<MovieDto> getMovieById(Integer id) {
        return movies.stream()
            .filter(m -> m.id.equals(id))
            .findFirst();
    }
}
