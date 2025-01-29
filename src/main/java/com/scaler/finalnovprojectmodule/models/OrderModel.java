package com.scaler.finalnovprojectmodule.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderModel extends BaseModel {
    private long customerId;
    private long amount;


//


//


    @ElementCollection
    private List<Long> productIdList = new ArrayList<>();
//
//
//
//


    enum OrderState {
        PENDING,
        CONFIRMED,
        SHIPPED,
        DELIVERED,
        CANCELLED,
    }

    @Enumerated(EnumType.STRING)
    private OrderState orderState = OrderState.PENDING;

    public OrderModel() {

    }

    public OrderModel(long customerId, long amount, List<Long> productIdList) {
        this.customerId = customerId;
        this.amount = amount;
        this.productIdList = productIdList;
    }

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "Ordermodel{" +
                ", productIdList=" + productIdList +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", orderState=" + orderState +
                '}';
    }
}
