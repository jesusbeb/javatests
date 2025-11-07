package org.example.javatests.movies.service;

import org.example.javatests.movies.data.MovieRepository;
import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

//Test para MovieService
public class MovieServiceShould {
    //Objeto de tipo movieService
    private MovieService movieService;

    //Metodo setUp con la anotacion Before, para incluir codigo que se repite y utilizan mas de un test
    @Before
    public void setUp() throws Exception{
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
                        new Movie(7, "Matrix", 136, Genre.ACTION),
                        new Movie(8, "Superman", 120, Genre.ACTION)
                )
        );
        //Pasamos el mockito del repositorio al movieService
        movieService = new MovieService(movieRepository);
    }

    /*////Simplicaremos el codigo
    @Test
    public void return_movies_by_genre(){

        //Obtenemos un Collection de las peliculas de COMEDY usando el metodo findMoviesByGenre
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        //Obtenemos una lista de los id de las peliculas que estan en el Collection movies
        List<Integer> movieIds =  movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        ////Esta linea anterior despues se convierte a una expresion lambda y como se repite en
        ////los dos test, se extrae a un metodo. Ambas cosas con ayuda de IntelliJ

        //Comprobamos que se hayan obtenido peliculas de COMEDY mediante los id esperados
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(3,6)));
        ////Despues como las dos lineas anteriores tienen la variable movieIds, con ayuda de
        ////IntelliJ hacemos un Inline, sucede en ambos test
    }

    @Test
    public void return_movies_by_duration(){
        Collection<Movie> movies = movieService.findMoviesByDuration(119);
        List<Integer> movieIds =  movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        assertThat( movieIds, CoreMatchers.is(Arrays.asList(2,3,4,5,6))  );
    }
     */

    @Test
    public void return_movies_by_genre(){
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_duration(){
        Collection<Movie> movies = movieService.findMoviesByDuration(119);
        assertThat( getMovieIds(movies), CoreMatchers.is(Arrays.asList(2,3,4,5,6)) );
    }

    @Test
    public void return_movies_by_name(){
        Collection<Movie> movies = movieService.findMoviesByName("SUPER");
        assertThat( getMovieIds(movies), CoreMatchers.is(Arrays.asList(4,8)) );
    }


    //Metodo comun extraido
    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}