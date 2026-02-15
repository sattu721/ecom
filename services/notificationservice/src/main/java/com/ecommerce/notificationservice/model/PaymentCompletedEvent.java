package com.ecommerce.notificationservice.model;

public record PaymentCompletedEvent(Long orderId, String customerEmail, String status) {

}
