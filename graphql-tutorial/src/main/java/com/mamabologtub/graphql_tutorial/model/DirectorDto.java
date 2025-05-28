package com.mamabologtub.graphql_tutorial.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record DirectorDto(Integer id, String name) {
    public static List<DirectorDto> directors = Arrays.asList(
        new DirectorDto(11,"Frank Darabont"),
        new DirectorDto(22, "Christopher Nolan"),
        new DirectorDto(33, "The Wachowskis")
    );

    public static Optional<DirectorDto> getDirectorById(Integer id) {
        return directors.stream()
            .filter(m -> m.id.equals(id))
            .findFirst();
    }
}
