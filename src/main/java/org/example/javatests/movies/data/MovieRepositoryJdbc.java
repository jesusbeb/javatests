package org.example.javatests.movies.data;

import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;


public class MovieRepositoryJdbc implements MovieRepository {
    //Atributos
    private JdbcTemplate jdbcTemplate;

    //Constructor
    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        //Se hace consulta a la BD y se transforma cada pelicula en un objeto Movie
        return jdbcTemplate.query("SELECT * FROM MOVIES", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }


    //Metodo escrito en lambda para obtener una pelicula de la BD
    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            //Obtenemos una pelicula de la tabla de la BD, indicando el nombre de los campos
            new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("minutes"),
                Genre.valueOf(rs.getString("genre"))) //El genero es un Enum, pero de la BD se obtiene un String, por lo que se hace la conversion
            ;
}
