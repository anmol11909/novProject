package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.models.OrderModel;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    public String makePayment(String orderId, long amount) throws StripeException;
}
