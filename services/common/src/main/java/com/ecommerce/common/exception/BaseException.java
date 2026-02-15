package com.ecommerce.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private final String code;
	private final HttpStatus status;

	protected BaseException(String code, String message, HttpStatus status) {
		super(message);
		this.code = code;
		this.status = status;
	}
}
