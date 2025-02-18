package com.nicolellis.moviedb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matchers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieTests {

    @LocalServerPort
    int port;

    @BeforeAll
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    /*
     * Functionalities for the Movie API:
     * Add new movie
     * Get movie by id
     * Get all movies
     * Get all movies by a certain director
     * Update movies
     * Delete movie
     * Error cases: Invalid release date, missing fields, invalid director, runtime
     * Movie fields: Name, release year, runtime, genre(s), rating, director, description, poster image
     */

    @Test
	public void movieCreationTest() {
        Movie testMovie = new Movie( "Test Title",
            2025, 120, "Action", 90, "Alex Nicolellis", "This is an example movie."
        );
        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(testMovie);
        Response r = RestAssured.given().
            contentType(ContentType.JSON).
            body(jsonBody).
            when().
            post("/movies");

        assertEquals(200, r.getStatusCode());
        assertEquals(jsonBody, r.getBody());
	}
    
}
