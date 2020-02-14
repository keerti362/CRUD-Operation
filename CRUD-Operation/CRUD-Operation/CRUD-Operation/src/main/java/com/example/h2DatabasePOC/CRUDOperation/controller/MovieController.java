package com.example.h2DatabasePOC.CRUDOperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;
import com.example.h2DatabasePOC.CRUDOperation.model.UserDetails;
import com.example.h2DatabasePOC.CRUDOperation.service.MovieServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Crud-Operation", description = "crud operation on movie database")
@RestController
@RequestMapping("/Movie")
public class MovieController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;

	@ApiOperation(value = "adding a movie object into a movie table")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "movie object has been added to the table"),
			@ApiResponse(code = 401, message = "the request requires user authentication"),
			@ApiResponse(code = 403, message = "accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "the server has not found anything matching to the Request-URI") })
	@PostMapping(value = "/addMovie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		movieServiceImpl.addMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getUserRatedMovies/{user_name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDetails> getUserRatedMovies(@PathVariable("user_name") String user_name) {
		return movieServiceImpl.getUserRatedMovies(user_name);

	}

	@GetMapping(value = "/getAllMovies")
	public List<Movie> getAllMovies() {
		return movieServiceImpl.getAllMovies();

	}

	@GetMapping(value = "/getMovie/{movie_id}")
	public Optional<Movie> getMovieById(@PathVariable("movie_id") int movie_id) {
		return movieServiceImpl.getMovieById(movie_id);

	}

	@GetMapping(value = "/getMovieByName/{movie_name}")
	public Optional<Movie> getMovieByName(@PathVariable("movie_name") String movie_name) {
		return movieServiceImpl.getMovieByName(movie_name);
	}

	@PutMapping(value = "/updateMovie/{movie_id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable("movie_id") int movie_id) {
		return movieServiceImpl.updateMovie(movie, movie_id);

	}

	@ApiOperation(value = "deleting a movie by Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "movie instance has been deleted for the Id entered"),
			@ApiResponse(code = 204, message = "No content found"),
			@ApiResponse(code = 401, message = "the Request requires user authentication"),
			@ApiResponse(code = 404, message = "The Server has not found anything matching to the Request-URI") })
	@DeleteMapping(value = "/deleteMovie/{movie_id}")
	public void deleteMovieById(
			@ApiParam(name = "movie_id", value = "The Id of the movie to be deleted", required = true) @PathVariable("movie_id") int movie_id) {
		movieServiceImpl.deleteMovieById(movie_id);
	}

	@DeleteMapping(value = "/deleteAllMovies")
	public void deleteAllMovies() {
		movieServiceImpl.deleteAllMovies();
	}

}
