package com.example.h2DatabasePOC.CRUDOperation.model;

import java.util.List;

public class UserDetails {

	private String user_name;

	private List<MoviesRate> moviesRate;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<MoviesRate> getMoviesRate() {
		return moviesRate;
	}

	public void setMoviesRate(List<MoviesRate> moviesRate) {
		this.moviesRate = moviesRate;
	}

}
