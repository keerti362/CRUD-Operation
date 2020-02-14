package com.example.h2DatabasePOC.CRUDOperation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1667666324921351819L;

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String Message) {
		super(Message);
	}

}
