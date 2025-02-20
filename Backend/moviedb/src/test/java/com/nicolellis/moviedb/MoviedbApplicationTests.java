package com.nicolellis.moviedb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import org.hamcrest.Matchers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MoviedbApplicationTests {

	@Test
	void contextLoads() {
	}

}
