package com.example.h2DatabasePOC.CRUDOperation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.h2DatabasePOC.CRUDOperation.advice.TrackExecutionTime;
import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;
import com.example.h2DatabasePOC.CRUDOperation.exception.InvalidInputException;
import com.example.h2DatabasePOC.CRUDOperation.exception.ResourceNotFoundException;
import com.example.h2DatabasePOC.CRUDOperation.model.MoviesRate;
import com.example.h2DatabasePOC.CRUDOperation.model.UserDetails;
import com.example.h2DatabasePOC.CRUDOperation.repository.MovieRepository;
import com.example.h2DatabasePOC.CRUDOperation.util.Validations;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private Validations valid;

	@Override
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = new ArrayList<Movie>();
		movieRepository.findAll().forEach(movie -> movieList.add(movie));
		return movieList;
	}

	@Override
	public Optional<Movie> getMovieById(int movie_id) {

		if (valid.isNullOrNegativeInput(movie_id)) {
			throw new InvalidInputException("invalid input..! please enter valid input");
		}

		Optional<Movie> findMovieById = movieRepository.findById(movie_id);
		if (!findMovieById.isPresent()) {
			throw new ResourceNotFoundException("Movie you are trying to search is not found");
		}
		return findMovieById;
	}

	@Override
	public Optional<Movie> getMovieByName(String movie_name) {
		return movieRepository.getMovieByName(movie_name);
	}

	@Override
	public Movie updateMovie(Movie movie, int movie_id) {

		if (valid.isNullOrNegativeInput(movie_id)) {
			throw new InvalidInputException("invalid input..! please enter valid input");
		}
		Optional<Movie> findMovieById = movieRepository.findById(movie_id);
		if (!findMovieById.isPresent()) {
			throw new ResourceNotFoundException("Movie you are trying to search is not found");
		}

		Movie movie1 = findMovieById.get();
		movie1.setUserName(movie1.getUserName());
		movie1.setUserName(movie1.getUserName());
		return movieRepository.save(movie1);
	}

	@Override
	public void deleteMovieById(int movie_id) {

		if (valid.isNullOrNegativeInput(movie_id)) {
			throw new InvalidInputException("invalid input..! please enter valid input");
		}

		movieRepository.deleteById(movie_id);
	}

	@Override
	public void deleteAllMovies() {
		movieRepository.deleteAll();
	}
	
	@TrackExecutionTime
	@Override
	public List<UserDetails> getUserRatedMovies(String user_name) {

		if (valid.isUserNameValid(user_name)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please enter non-numeric username");
		}

		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		HashMap<String, List<MoviesRate>> hm = new HashMap<String, List<MoviesRate>>();

		List<Movie> m = movieRepository.findByUser_Name(user_name);
		if (!m.isEmpty()) {
			m.forEach(movie -> {

				if (hm.get(movie.getUserName()) == null) {
					MoviesRate moviesRate = new MoviesRate();
					moviesRate.setMovieName(movie.getMovieName());
					moviesRate.setRating(movie.getRating());
					List<MoviesRate> newList = new ArrayList<MoviesRate>();
					newList.add(moviesRate);
					hm.put(movie.getUserName(), newList);
				} else {

					
					
					
					MoviesRate moviesRate = new MoviesRate();
					moviesRate.setMovieName(movie.getMovieName());
					moviesRate.setRating(movie.getRating());
					List<MoviesRate> newList = hm.get(movie.getUserName());
					newList.add(moviesRate);
					hm.put(movie.getUserName(), newList);
				}
			});
		}

		for (String strkey : hm.keySet()) {
			UserDetails userDetails = new UserDetails();
			userDetails.setUser_name(strkey);
			userDetails.setMoviesRate(hm.get(strkey));
			userDetailsList.add(userDetails);
		}
		return userDetailsList;
	}

}
