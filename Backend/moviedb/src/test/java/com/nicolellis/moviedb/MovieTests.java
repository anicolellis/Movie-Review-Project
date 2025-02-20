package com.nicolellis.moviedb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
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
	public void movieCRUDTest() {
        /*
         * Create fake movie data and send it via POST request.
         */
        Movie testMovie = new Movie( "Test Title",
            2025, 120, "Action", 90, "Alex Nicolellis", "This is an example movie."
        );
        
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonBody = mapper.writeValueAsString(testMovie);
        int testMovieId = RestAssured.given().
            contentType(ContentType.JSON).
            body(testMovie). //note: I think I can just put the testMovie here, try it
            when().
            post("/movies").then().statusCode(200).
            body("description",equalTo(testMovie.getDescription())).
            extract().path("id");

        /*
         * Retrieve the data using a GET request.
         */
        Movie m = RestAssured.get("movies/"+testMovieId).then()
            .statusCode(200)
            .body("description",equalTo(testMovie.getDescription()))
            .extract().as(Movie.class);
        
        //assertEquals(testMovie, m); //idk if the id will interfere with this

        /*
         * Update the data using a PUT request.
         */
        m.setDescription("This is an updated description");
        Movie updatedMovie = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(m) 
            .when().put("movies/"+testMovieId).then().assertThat()
            .statusCode(200)
            .body("description",equalTo(m.getDescription()))
            .extract().as(Movie.class);

        /*
         * Delete the data using a DELETE request.
         */
        RestAssured.delete("movies/"+testMovieId).then()
            .statusCode(200)
            .body("description",equalTo(updatedMovie.getDescription()));

	}
    
}
