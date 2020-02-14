package com.example.h2DatabasePOC.CRUDOperation.service;

import java.util.List;
import java.util.Optional;

import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;
import com.example.h2DatabasePOC.CRUDOperation.model.UserDetails;


public interface MovieService {

	public Movie addMovie(Movie movie);

	public List<Movie> getAllMovies();

	public Optional<Movie> getMovieById(int movieId);
	
	public Optional<Movie> getMovieByName(String movie_name);
	
	public Movie updateMovie(Movie movie, int movie_id);

	public void deleteMovieById(int movieId);

	public void deleteAllMovies();

	public List<UserDetails> getUserRatedMovies(String userName);

}
