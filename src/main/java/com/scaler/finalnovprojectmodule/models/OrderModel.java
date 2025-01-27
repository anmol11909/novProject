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

    @ElementCollection
    private List<Long> productIdList = new ArrayList<>();

    enum OrderState{
        PENDING,
        CONFIRMED,
        SHIPPED,
        DELIVERED,
        CANCELLED,
    }

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    public OrderModel(){

    }

    public OrderModel(long customerId, long amount, List<Long> productIdList){
        this.customerId = customerId;
        this.amount = amount;
        this.productIdList = productIdList;
    }

    public List<Long> getProductIdList() {
        return productIdList;
    }
}
