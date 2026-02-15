package com.ecommerce.common.exception;

import org.springframework.http.HttpStatus;

public class PaymentFailedException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentFailedException() {
        super("PAYMENT_FAILED", "Payment processing failed", HttpStatus.BAD_REQUEST);
    }

}
