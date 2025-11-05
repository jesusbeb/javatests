package org.example.javatests.movies.data;

import org.example.javatests.movies.model.Movie;

import java.util.Collection;

//Repositorio para trabajar con la BD
public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);
}
