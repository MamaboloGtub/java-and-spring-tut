package com.mamabologtub.graphql_tutorial;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlTutorialApplication.class, args);
	}

    /**
     * The GraphQl implementation does not Long scalar type by default this bean is used to create graphQl Scalar extender
     * which represents java.lang.Long.
     * */
    @Bean
    public graphql.schema.GraphQLScalarType graphqlScalarType() {
        return  ExtendedScalars.GraphQLLong;
    }

}
