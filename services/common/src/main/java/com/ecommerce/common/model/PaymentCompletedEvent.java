package com.ecommerce.common.model;

public record PaymentCompletedEvent(Long orderId, String customerEmail, String status) {

}
