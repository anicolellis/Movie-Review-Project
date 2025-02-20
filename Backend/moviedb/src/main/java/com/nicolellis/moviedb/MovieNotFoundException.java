package com.nicolellis.moviedb;

public class MovieNotFoundException extends RuntimeException {
    MovieNotFoundException(int id) {
        super("Could not find movie with id " + id);
    }
}
