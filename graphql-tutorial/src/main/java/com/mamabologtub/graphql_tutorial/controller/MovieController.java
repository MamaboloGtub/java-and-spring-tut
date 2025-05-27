package com.mamabologtub.graphql_tutorial.controller;

import com.mamabologtub.graphql_tutorial.model.Director;
import com.mamabologtub.graphql_tutorial.model.Movie;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    @QueryMapping //map this function to the graphQl query
    public List<Movie> movies() {
        return Movie.movies;
    }
    @QueryMapping
    public Optional<Movie> movieById(@Argument Integer id) {
        return  Movie.getMovieById(id);
    }

    @SchemaMapping
    public Optional<Director> director(Movie movie) {
        return  Director.getDirectorById(movie.directorId());
    }
}
