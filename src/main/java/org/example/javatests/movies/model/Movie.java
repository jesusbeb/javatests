package org.example.javatests.movies.model;

import java.util.Objects;

public class Movie {
    //Atributos
    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;

    //Constructor
    public Movie(String name, int minutes, Genre genre){
        this(null, name, minutes, genre); //con this llamamos al otro constructor de abajo
    }

    //Constructor
    public Movie(Integer id, String name, int minutes, Genre genre){
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    //Getters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    //Sobre escribimos estos metodos para que el test pueda comparar los objetos que
    //llegan de la BD, con los objetos esperados

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes &&
                Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) &&
                genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
    }
}
