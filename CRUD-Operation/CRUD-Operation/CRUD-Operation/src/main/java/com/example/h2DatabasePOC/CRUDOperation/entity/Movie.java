package com.example.h2DatabasePOC.CRUDOperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MOVIE")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;

	@Column(name = "movie_name", length = 50)
	private String movieName;

	@Column(name = "description", length = 50)
	private String description;

	@Column(name = "genre", length = 50)
	private String genre;

	@Column(name = "user_name", length = 50)
	private String userName;

	@Column(name = "rating", length = 50)
	private int rating;

	public Movie() {

	}

	public Movie(String movieName, String description, String genre, String userName, int rating) {
		super();
		this.movieName = movieName;
		this.description = description;
		this.genre = genre;
		this.userName = userName;
		this.rating = rating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}