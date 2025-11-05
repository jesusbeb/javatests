package org.example.javatests.movies.model;

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
}
