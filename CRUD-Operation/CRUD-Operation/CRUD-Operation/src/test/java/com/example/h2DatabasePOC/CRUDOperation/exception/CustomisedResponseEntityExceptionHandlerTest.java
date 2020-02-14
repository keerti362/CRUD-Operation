package com.example.h2DatabasePOC.CRUDOperation.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.WebRequest;

@RunWith(SpringRunner.class)
public class CustomisedResponseEntityExceptionHandlerTest {

	@Mock
	WebRequest request;

	CustomisedResponseEntityExceptionHandler customisedResponseEntityExceptionHandler = new CustomisedResponseEntityExceptionHandler();

	ResourceNotFoundException ResourceNotFoundException = new ResourceNotFoundException();

	InvalidInputException invalidInputException = new InvalidInputException();

	Exception ex = new Exception();

	@Test
	public void testHandleAllExceptions() {
		customisedResponseEntityExceptionHandler.handleAllExceptions(ex, request);

	}

	@Test
	public void testHandleResourseNotFoundException() {
		customisedResponseEntityExceptionHandler.handleResourseNotFoundException(ResourceNotFoundException, request);

	}

	@Test
	public void testHandleInvalidInputException() {
		customisedResponseEntityExceptionHandler.handleInvalidInputException(invalidInputException, request);

	}

}
