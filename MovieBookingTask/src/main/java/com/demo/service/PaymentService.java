package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import jakarta.annotation.PostConstruct;

@Service
public class PaymentService {

    @Value("${stripe.apiKey}")
    private String apiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey;
    }

    public PaymentIntent createPaymentIntent(long amount) {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", "usd");
        params.put("payment_method_types", new String[]{"card"});

        try {
            return PaymentIntent.create(params);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}