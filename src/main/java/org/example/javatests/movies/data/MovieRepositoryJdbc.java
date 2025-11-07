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

        //En el array se indica solo el valor necesario, en este caso el id
        Object[] args = { id };

        //queryForObject devuelve un solo objeto. En cambio query devuelve un Collection de objetos.
        //El id se envia en los argumentos, y debido a la interfaz de jdbcTemplate debe ser un array de objetos
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE ID = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        //Se hace consulta a la BD y movieMapper transforma cada pelicula en un objeto Movie
        return jdbcTemplate.query("SELECT * FROM MOVIES", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        //Insertamos la pelicula recibida por parametro, en la BD
        jdbcTemplate.update("INSERT INTO movies(name, minutes, genre) values(?,?,?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());

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
