package com.ecommerce.common.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex) {

		ErrorResponse error = new ErrorResponse(ex.getCode(), ex.getMessage(), LocalDateTime.now());

		return new ResponseEntity<>(error, ex.getStatus());
	}

}
