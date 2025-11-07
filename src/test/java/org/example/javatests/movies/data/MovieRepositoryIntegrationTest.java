package org.example.javatests.movies.data;

import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {


    @Test
    public void load_all_movies() throws SQLException {

        //Conexion a la BD
        //con DriverManagerDataSource se crea una BD en memoria de pruebas con el formato de MySQL,
        //esto gracias a la libreria h2database, que se agrega en las dependencias.
        //Finalmente se almacena en un objeto DataSource
        DataSource dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        //Usamos ScripUtils que viene en la libreria de spring jdbc, le pasamos la conexion la cual obtenemos del dataSource,
        //luego le indicamos la ruta donde tenemos el archivo sql con las instrucciones para crear la tabla de BD. Creamos la
        //excepcion en la cabecera del metodo, por si no se halla el archivo sql
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        //JdbcTemplate necesita un dataSource que representa una conexion a la BD
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //Instanciamos el repositorio y le pasamos el jdbcTemplate
        MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

        //Obtenemos todas las peliculas en un Collection
        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        //Comprobamos que las peliculas que se devuelven de la BD, son las mismas que esperamos
        assertThat( movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

}