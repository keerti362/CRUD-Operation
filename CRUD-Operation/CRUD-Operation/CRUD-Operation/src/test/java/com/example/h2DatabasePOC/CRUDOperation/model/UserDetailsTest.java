package com.example.h2DatabasePOC.CRUDOperation.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserDetailsTest {

	UserDetails userDetails = new UserDetails();
	MoviesRate MoviesRate = new MoviesRate();
	List<MoviesRate> list = new ArrayList<MoviesRate>();

	@Test
	public void test_positive() {
		userDetails.setUser_name("user_name");
		userDetails.setMoviesRate(list);

		assertEquals("user_name", userDetails.getUser_name());
		assertEquals(list, userDetails.getMoviesRate());
	}

	@Test
	public void test_negative() {
		userDetails.setUser_name("user_name");
		userDetails.setMoviesRate(list);

		assertNotEquals("user_oname", userDetails.getUser_name());
		assertNotEquals("list", userDetails.getMoviesRate());
	}

}
