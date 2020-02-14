
package com.example.h2DatabasePOC.CRUDOperation.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;
import com.example.h2DatabasePOC.CRUDOperation.service.MovieServiceImpl;

@RunWith(SpringRunner.class)
public class MovieControllerTest {

	Movie movie = new Movie();

	@InjectMocks
	private MovieController movieController;

	@Mock
	private MovieServiceImpl movieServiceImpl;

	@Test
	public void testAddMovie() {

		Mockito.doReturn(movie).when(movieServiceImpl).addMovie(movie);
		movieController.addMovie(movie);
		assertNotNull(movie);
	}

	@Test
	public void testGetAllMovies() {

		List<Movie> movieList = new ArrayList<Movie>();
		Mockito.doReturn(movieList).when(movieServiceImpl).getAllMovies();
		movieController.getAllMovies();
	}

	@Test
	public void testGetUserRatedMovies() {
		List<Movie> movieList = new ArrayList<Movie>();
		Mockito.doReturn(movieList).when(movieServiceImpl).getUserRatedMovies(movie.getUserName());
		movieController.getUserRatedMovies(movie.getUserName());
	}

	@Test
	public void testGetMovieById() {
		Movie movie1 = new Movie();
		movie1.setMovieId(1);
		Optional<Movie> optional = Optional.ofNullable(movie1);
		Mockito.doReturn(optional).when(movieServiceImpl).getMovieById(movie1.getMovieId());
		movieController.getMovieById(movie1.getMovieId());
	}
	
	@Test
	public void getMovieByName() {
		Movie movie1 = new Movie();
		movie1.setMovieName("movieName");
		Optional<Movie> movie2=Optional.ofNullable(movie1);
		Mockito.doReturn(movie2).when(movieServiceImpl).getMovieByName(movie1.getMovieName());
		movieController.getMovieByName(movie1.getMovieName());
	}

	@Test
	public void testUpdateMovie() throws Exception {
		Mockito.doReturn(movie).when(movieServiceImpl).updateMovie(movie, movie.getMovieId());
		movieController.updateMovie(movie, movie.getMovieId());
	}

	@Test
	public void testDeleteMovieById() {
		Mockito.doNothing().when(movieServiceImpl).deleteMovieById(movie.getMovieId());
		movieController.deleteMovieById(movie.getMovieId());
	}

	@Test
	public void testDeleteAllMovies() {
		Mockito.doNothing().when(movieServiceImpl).deleteAllMovies();
		movieController.deleteAllMovies();
	}

}
