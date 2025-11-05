package org.example.javatests.movies.service;

import org.example.javatests.movies.data.MovieRepository;
import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

//Test para MovieService
public class MovieServiceShould {

    @Test
    public void return_movies_by_genre(){
        //Creamos un mockito de la clase MovieRepository (un repositorio falso con la informacion que indiquemos)
        //Cuando se llame al metodo findAll de la clase MovieRepository, indicamos que retorne una lista de
        //diferentes tipos de peliculas, la cual indicamos aqui mismo.
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Night", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something Abour Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(1, "Matrix", 136, Genre.ACTION)
                )
        );

        //Instanciamos movieService y le pasamos el mockito del repositorio
        MovieService movieService = new MovieService(movieRepository);
        //Obtenemos un Collection de las peliculas de COMEDY usando el metodo findMoviesByGenre
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        //Obtenemos una lista de los id de las peliculas que estan en el Collection movies
        List<Integer> movieIds =  movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        //Comprobamos que se hayan obtenido peliculas de COMEDY mediante los id esperados
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(3,6)));
    }

}