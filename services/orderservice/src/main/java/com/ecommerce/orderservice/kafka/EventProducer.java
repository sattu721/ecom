package com.ecommerce.orderservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.common.model.OrderCreatedEvent;
import com.ecommerce.common.model.PaymentCompletedEvent;

@Service
public class EventProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
	
    public void sendOrderCreated(OrderCreatedEvent event) {
        kafkaTemplate.send("order-created", event);
    }

    public void sendPaymentCompleted(PaymentCompletedEvent event) {
        kafkaTemplate.send("payment-completed", event);
    }

}
