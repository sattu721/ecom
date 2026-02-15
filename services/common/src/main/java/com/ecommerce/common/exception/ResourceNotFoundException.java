package com.ecommerce.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super("NOT_FOUND", message, HttpStatus.NOT_FOUND);
	}

}
