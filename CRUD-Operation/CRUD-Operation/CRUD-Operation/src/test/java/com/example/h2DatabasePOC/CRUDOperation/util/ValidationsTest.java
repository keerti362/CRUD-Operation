package com.example.h2DatabasePOC.CRUDOperation.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.h2DatabasePOC.CRUDOperation.entity.Movie;

@RunWith(SpringRunner.class)
public class ValidationsTest {

	Validations validation=new Validations();
	
	Movie movie=new Movie();
	
	@Test
	public void testIsNullOrNegativeInput() {
		
		movie.setMovieId(1);
		validation.isNullOrNegativeInput(movie.getMovieId());
		assertEquals(1,movie.getMovieId());
	}
	
	@Test
	public void testIsNullOrNegativeInput_NullId() {
		movie.setMovieId(0);
		validation.isNullOrNegativeInput(movie.getMovieId());
		assertEquals(0,movie.getMovieId());
	}
	
	@Test
	public void testIsUserNameValid() {
		movie.setUserName("Keerti Patil");
		validation.isUserNameValid(movie.getUserName());
		assertEquals("Keerti Patil",movie.getUserName());
	}
	
	@Test
	public void testIsUserNameValid_NotValid() {
		movie.setUserName("Keerti patil4");
		validation.isUserNameValid(movie.getUserName());
//		assertEquals("Keerti Patil4",movie.getUserName());
	}
	

}
