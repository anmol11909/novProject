package com.scaler.finalnovprojectmodule.service;

import com.stripe.exception.StripeException;

public interface PaymentService {
    public String makePayment(String orderId, long amount) throws StripeException;
}
