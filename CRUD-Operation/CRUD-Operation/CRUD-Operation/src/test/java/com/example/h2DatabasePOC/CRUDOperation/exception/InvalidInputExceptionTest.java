package com.example.h2DatabasePOC.CRUDOperation.exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class InvalidInputExceptionTest {

	@Test
	public void testInvalidInputException() {
		
		InvalidInputException invalidInputException=new InvalidInputException();
		assertNotNull(invalidInputException);
		InvalidInputException invalidInputException1=new InvalidInputException("message");
		assertNotNull(invalidInputException1);
	}

}
