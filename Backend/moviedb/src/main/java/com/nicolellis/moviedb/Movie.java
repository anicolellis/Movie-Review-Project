package com.nicolellis.moviedb;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @JsonProperty(value="id")
    private Integer id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int release_year;

    @Getter
    @Setter
    private int runtime;

    @Getter
    @Setter
    private String genre;

    @Getter
    @Setter
    private int rating;

    @Getter
    @Setter
    private String director;

    @Getter
    @Setter
    private String description;

    public Movie(String title, int release_year, int runtime, String genre, int rating, String director, String description) {
        this.title=title;
        this.release_year=release_year;
        this.runtime=runtime;
        this.genre=genre;
        this.rating=rating;
        this.director=director;
        this.description=description;
    }
}
