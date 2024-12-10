package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Movie {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;

    private String title;

    private String director;

    public Movie() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
    
    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }
}
