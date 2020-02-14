package com.example.h2DatabasePOC.CRUDOperation.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.h2DatabasePOC.CRUDOperation.model.MoviesRate;

@RunWith(SpringRunner.class)
public class MovieTest {

	List<MoviesRate> movieRate = new ArrayList<MoviesRate>();
	Movie movie = new Movie();
	Movie movie1 = new Movie("movieName", "description", "genre", "userName", 5);

	@Test
	public void movieTest_Positive() {
		movie.setMovieName("movieName");
		movie.setGenre("genre");
		movie.setDescription("description");
		movie.setMovieId(1);
		movie.setUserName("user_name");
		movie.setRating(3);
		assertEquals("movieName", movie.getMovieName());
		assertEquals("genre", movie.getGenre());
		assertEquals("description", movie.getDescription());
		assertEquals("user_name", movie.getUserName());
		assertEquals(3, movie.getRating());
		assertEquals(1, movie.getMovieId());

	}

	@Test
	public void movieTest_Negative() {

		movie.setMovieName("movieName");
		movie.setGenre("genre");
		movie.setDescription("description");
		movie.setMovieId(1);
		movie.setUserName("user_name");
		movie.setRating(3);

		assertNotEquals("movieName1", movie.getMovieName());
		assertNotEquals("genree", movie.getGenre());
		assertNotEquals("desceription", movie.getDescription());
		assertNotEquals("usere_name", movie.getUserName());
		assertNotEquals(4, movie.getRating());
		assertNotEquals(2, movie.getMovieId());

	}

}
