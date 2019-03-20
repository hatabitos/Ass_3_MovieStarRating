package com.example.ahattab.moviestarrating;

import java.io.Serializable;

public class Movie implements Serializable {
    private String movieName;
    private float movieRating;
    private int movieId;

    public Movie(String movieName, float movieRating, int movieId) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieId = movieId;
    }

    public Movie() { }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
