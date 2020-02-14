package com.example.h2DatabasePOC.CRUDOperation.exception;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ErrorResponseTest {

	ErrorResponse errorResponse = new ErrorResponse();
	ErrorResponse errorResponse1 = new ErrorResponse(new Date(), "message", "details");

	@Test
	public void testErrorResponse_Positive() {
		errorResponse.setDetails("details");
		errorResponse.setMessage("message");
		errorResponse.setTimestamp(new Date());

		assertEquals("details", errorResponse.getDetails());
		assertEquals("message", errorResponse.getMessage());
		assertEquals(new Date(), errorResponse.getTimestamp());
	}

	@Test
	public void testErrorResponse_Negative() {
		errorResponse.setDetails("details");
		errorResponse.setMessage("message");
		errorResponse.setTimestamp(new Date());

		assertNotEquals("detailss", errorResponse.getDetails());
		assertNotEquals("messagge", errorResponse.getDetails());
		assertNotEquals("date", errorResponse.getTimestamp());
	}

}
