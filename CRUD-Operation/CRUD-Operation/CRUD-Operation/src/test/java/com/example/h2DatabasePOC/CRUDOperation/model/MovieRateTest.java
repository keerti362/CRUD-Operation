package com.example.h2DatabasePOC.CRUDOperation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.example.h2DatabasePOC.CRUDOperation.model.MoviesRate;

public class MovieRateTest {

	MoviesRate movieRate = new MoviesRate();

	@Test
	public void test_Positive() {

		movieRate.setMovieName("movie_name");
		movieRate.setRating(3);

		assertEquals("movie_name", movieRate.getMovieName());
		assertEquals(3, movieRate.getRating());

	}

	@Test
	public void test_negative() {

		movieRate.setMovieName("movie_name");
		movieRate.setRating(3);

		assertNotEquals("movie_name1", movieRate.getMovieName());
		assertNotEquals(4, movieRate.getRating());

	}

}
