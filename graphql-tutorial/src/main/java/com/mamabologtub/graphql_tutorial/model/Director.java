package com.mamabologtub.graphql_tutorial.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Director(Integer id, String name) {
    public static List<Director> directors = Arrays.asList(
        new Director(11,"Frank Darabont"),
        new Director(22, "Christopher Nolan"),
        new Director(33, "The Wachowskis")
    );

    public static Optional<Director> getDirectorById(Integer id) {
        return directors.stream()
            .filter(m -> m.id.equals(id))
            .findFirst();
    }
}
