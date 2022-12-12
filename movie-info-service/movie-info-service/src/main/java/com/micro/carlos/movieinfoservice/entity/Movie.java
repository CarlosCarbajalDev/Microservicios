package com.micro.carlos.movieinfoservice.entity;

public class Movie {
    private String MovieId;
    private String name;
    private String description;

    public Movie(String movieId, String name, String description) {
        MovieId = movieId;
        this.name = name;
        this.description = description;
    }

    public String getMovieId() {
        return MovieId;
    }

    public void setMovieId(String movieId) {
        MovieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
