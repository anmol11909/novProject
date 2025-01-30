package com.scaler.finalnovprojectmodule.Dto;

public class PaymentRequestDto {
    String orderId;
    long amount;

    public PaymentRequestDto(String orderId, long amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public PaymentRequestDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
