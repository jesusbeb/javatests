package org.example.javatests.movies.data;

import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        //Conexion a la BD
        //con DriverManagerDataSource se crea una BD en memoria de pruebas con el formato de MySQL,
        //esto gracias a la libreria h2database, que se agrega en las dependencias.
        //Finalmente se almacena en un objeto DataSource
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        //Usamos ScripUtils que viene en la libreria de spring jdbc, le pasamos la conexion la cual obtenemos del dataSource,
        //luego le indicamos la ruta donde tenemos el archivo sql con las instrucciones para crear la tabla de BD. Creamos la
        //excepcion en la cabecera del metodo, por si no se halla el archivo sql
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        //JdbcTemplate necesita un dataSource que representa una conexion a la BD
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //Instanciamos el repositorio y le pasamos el jdbcTemplate
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }


    @Test
    public void load_all_movies() throws SQLException {

        //Obtenemos todas las peliculas en un Collection
        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        //Comprobamos que las peliculas que se devuelven de la BD, son las mismas que esperamos
        assertThat( movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }


    @Test
    public void load_movie_by_id(){

        Movie movie = movieRepositoryJdbc.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }


    @Test
    public void insert_a_movie(){

        //Creamos el objeto de la nueva pelicula
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

        //Usamos el metodo del repositorio para guardar la nueva pelicula
        movieRepositoryJdbc.saveOrUpdate(movie);

        //Recuperamos la nueva pelicula por el id que se le debio ser asignado
        Movie movieFromDb = movieRepositoryJdbc.findById(4);

        //Comprobamos que la pelicula que se recupera de la BD es la misma que se guardo
        assertThat( movieFromDb, is(new Movie(4, "Super 8", 112, Genre.THRILLER)) );
    }


    //La anotacion After siempre se ejecuta despues de cada test
    //Este metodo sirve para borrar los datos de la BD
    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
    }

}