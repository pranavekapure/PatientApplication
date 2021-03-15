package com.patient.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;
	private List<String> errors;

	public APIException(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

}
