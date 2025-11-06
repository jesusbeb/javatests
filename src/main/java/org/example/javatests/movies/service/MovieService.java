package org.example.javatests.movies.service;

import org.example.javatests.movies.data.MovieRepository;
import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

//Servicio para la logica de negocios
public class MovieService {
    //Atributo
    private MovieRepository movieRepository;

    //Constructor
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //Metodo que busca peliculas por genero y devuelve un Collection de peliculas
    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duration) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= duration).collect(Collectors.toList());
    }
}
