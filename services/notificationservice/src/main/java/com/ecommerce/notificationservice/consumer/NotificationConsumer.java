package com.ecommerce.notificationservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ecommerce.notificationservice.model.OrderCreatedEvent;
import com.ecommerce.notificationservice.model.PaymentCompletedEvent;

@Component
public class NotificationConsumer {

    @KafkaListener(topics = "order-created", groupId = "notification-group")
    public void orderCreated(OrderCreatedEvent event) {
        System.out.println("Email: Order created -> " + event.orderId());
    }

    @KafkaListener(topics = "payment-completed", groupId = "notification-group")
    public void paymentCompleted(PaymentCompletedEvent event) {
        System.out.println("Email: Payment successful -> " + event.orderId());
    }
}

