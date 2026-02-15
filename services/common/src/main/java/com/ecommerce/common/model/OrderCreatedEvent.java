package com.ecommerce.common.model;

public record OrderCreatedEvent(Long orderId, String customerEmail, double amount) {

}
