package com.example.h2DatabasePOC.CRUDOperation.exception;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ResourceNotFoundExceptionTest {

	@Test
	public void testResourceNotFoundException() {
		
		ResourceNotFoundException resourceNotFoundException=new ResourceNotFoundException();
		assertNotNull(resourceNotFoundException);
		
		ResourceNotFoundException resourceNotFoundException1=new ResourceNotFoundException("message");
		assertNotNull(resourceNotFoundException1);
		
	
	}

}
