package com.ecommerce.notificationservice.model;

public record OrderCreatedEvent(Long orderId, String customerEmail, double amount) {

}
