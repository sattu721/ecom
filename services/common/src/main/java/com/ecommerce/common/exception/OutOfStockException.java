package com.ecommerce.common.exception;

import org.springframework.http.HttpStatus;

public class OutOfStockException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfStockException(String product) {
		super("OUT_OF_STOCK", product + " is out of stock", HttpStatus.BAD_REQUEST);
	}

}
