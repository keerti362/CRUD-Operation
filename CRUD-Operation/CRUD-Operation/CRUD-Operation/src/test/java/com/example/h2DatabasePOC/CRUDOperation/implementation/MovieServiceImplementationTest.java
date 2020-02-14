package com.example.h2DatabasePOC.CRUDOperation.implementation;

import static org.junit.Assert.assertEquals;
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
import org.springframework.web.server.ResponseStatusException;

import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;
import com.example.h2DatabasePOC.CRUDOperation.exception.InvalidInputException;
import com.example.h2DatabasePOC.CRUDOperation.exception.ResourceNotFoundException;
import com.example.h2DatabasePOC.CRUDOperation.model.UserDetails;
import com.example.h2DatabasePOC.CRUDOperation.repository.MovieRepository;
import com.example.h2DatabasePOC.CRUDOperation.service.MovieServiceImpl;
import com.example.h2DatabasePOC.CRUDOperation.util.Validations;

@RunWith(SpringRunner.class)
public class MovieServiceImplementationTest {

	Movie movie = new Movie();

	@InjectMocks
	private MovieServiceImpl movieServiceImpl;

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private Validations validations;

	@Test
	public void testAddMovie() {

		Mockito.doReturn(movie).when(movieRepository).save(movie);
		movieServiceImpl.addMovie(movie);
	}

	@Test
	public void testGetAllMovies() {
		List<Movie> movieList = new ArrayList<Movie>();
		Mockito.doReturn(movieList).when(movieRepository).findAll();
		movieServiceImpl.getAllMovies();
		assertNotNull(movieList);
	}

	@Test
	public void testGetMovieById() {
		movie.setMovieId(2);
		Optional<Movie> findById = Optional.ofNullable(movie);
		Mockito.doReturn(findById).when(movieRepository).findById(movie.getMovieId());
		movieServiceImpl.getMovieById(movie.getMovieId());
		assertEquals(2, movie.getMovieId());
	}

	@Test(expected = InvalidInputException.class)
	public void testGetMovieById_NullId() {
		movie.setMovieId(-11);
		Mockito.doReturn(true).when(validations).isNullOrNegativeInput(movie.getMovieId());
		movieServiceImpl.getMovieById(movie.getMovieId());

	}

	@Test(expected = ResourceNotFoundException.class)
	public void testGetMovieById_MovieNotFound() {
		Movie movie1 = new Movie();
		movie1.setMovieId(2);
		Mockito.doReturn(movie).when(movieRepository).save(movie1);
		movieServiceImpl.getMovieById(movie1.getMovieId());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testUpdateMovie_MovieNotFound() {
		Movie movie1 = new Movie();
		movie1.setMovieId(2);
		Mockito.doReturn(movie1).when(movieRepository).save(movie1);
		movieServiceImpl.updateMovie(movie, movie1.getMovieId());
	}

	@Test
	public void testUpdateMovie() {
		Movie movie1 = new Movie();
		movie1.setMovieId(1);
		Optional<Movie> findById = Optional.ofNullable(movie1);
		Mockito.doReturn(findById).when(movieRepository).findById(2);
		movieServiceImpl.updateMovie(movie1, 2);
		assertEquals(1, movie1.getMovieId());

	}

	@Test(expected = InvalidInputException.class)
	public void testUpdateMovieById_NullId() {
		Movie movie1 = new Movie();
		movie1.setMovieId(0);
		Mockito.doReturn(true).when(validations).isNullOrNegativeInput(movie1.getMovieId());
		movieServiceImpl.updateMovie(movie1, movie1.getMovieId());
	}

	@Test(expected = InvalidInputException.class)
	public void deleteMovieByIdTest() {
		movie.setMovieId(0);
		Mockito.doReturn(true).when(validations).isNullOrNegativeInput(movie.getMovieId());
		movieServiceImpl.deleteMovieById(movie.getMovieId());
	}

	@Test
	public void testDeleteMovieById() {
		movie.setMovieId(4);
		Mockito.doNothing().when(movieRepository).deleteById(movie.getMovieId());
		movieServiceImpl.deleteMovieById(movie.getMovieId());
		assertEquals(4, movie.getMovieId());
	}

	@Test
	public void testGetMovieByName() {
		movie.setMovieName("movieName");
		Optional<Movie> movie1 = Optional.ofNullable(movie);
		Mockito.doReturn(movie1).when(movieRepository).getMovieByName(movie.getMovieName());
		movieServiceImpl.getMovieByName(movie.getMovieName());
		assertEquals("movieName", movie.getMovieName());
	}

	@Test
	public void testdeleteAllMovieTest() {
		Mockito.doNothing().when(movieRepository).deleteAll();
		movieServiceImpl.deleteAllMovies();
	}

	@Test(expected = ResponseStatusException.class)
	public void testGetUserRatedMovie_NotValid() {
		movie.setUserName("Keerti4");
		Mockito.doReturn(true).when(validations).isUserNameValid(movie.getUserName());
		movieServiceImpl.getUserRatedMovies(movie.getUserName());

	}

	@Test
	public void testGetUserRatedMovies() {
		Movie movie1 = new Movie();
		movie1.setUserName("Keerti Patil");
		List<UserDetails> list = new ArrayList<UserDetails>();
		UserDetails userDetails = new UserDetails();
		list.add(userDetails);
		List<Movie> list1 = new ArrayList<Movie>();
		list1.add(movie1);
		List<Movie> newList = new ArrayList<Movie>();
		newList.add(null);

   		Mockito.doReturn(list1).when(movieRepository).findByUser_Name(movie1.getUserName());
		movieServiceImpl.getUserRatedMovies(movie1.getUserName());
		assertNotNull(list);

	}
	
//	@Test
//	public void testGetUserRatedMovies_NullList() {
//		Movie movie1 = new Movie();
//		movie1.setUserName("Keerti Patil");
//		List<UserDetails> list = new ArrayList<UserDetails>();
//		UserDetails userDetails = new UserDetails();
//		list.add(userDetails);
//		List<Movie> list1 = new ArrayList<Movie>();
//		list1.add(movie1);
//        MoviesRate movieRate=new MoviesRate();
//        movieRate.setMovieName("movieName");
//        movieRate.setRating(3);
//        MoviesRate movieRate1=new MoviesRate();
//        movieRate1.setMovieName("movieName1");
//        movieRate1.setRating(4);
//        List<MoviesRate> list2=new ArrayList<MoviesRate>();
//        list2.add(movieRate);
//        list2.add(movieRate1);
//        userDetails.setUser_name(movie1.getUserName()); 
//        userDetails.setMoviesRate(list2);
//        
//		List<MoviesRate> newList=new ArrayList<MoviesRate>();
//		newList.add(movieRate);
//   		Mockito.doReturn(list1).when(movieRepository).findByUser_Name(movie1.getUserName());
//		movieServiceImpl.getUserRatedMovies(movie1.getUserName());
//		assertNotNull(list);
//	}

}
