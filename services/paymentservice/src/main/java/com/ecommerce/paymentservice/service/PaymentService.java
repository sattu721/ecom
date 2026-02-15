package com.ecommerce.paymentservice.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.paymentservice.dto.PaymentRequest;
import com.ecommerce.paymentservice.entity.Payment;
import com.ecommerce.paymentservice.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment processPayment(PaymentRequest request) {

        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .paymentMode(request.getPaymentMode())
                .status("INITIATED")
                .createdAt(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);

        boolean success = new Random().nextInt(10) > 2;

        if (success) {
            payment.setStatus("SUCCESS");
            payment.setTransactionId(UUID.randomUUID().toString());
        } else {
            payment.setStatus("FAILED");
        }

        return paymentRepository.save(payment);
    }

    public Payment getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}