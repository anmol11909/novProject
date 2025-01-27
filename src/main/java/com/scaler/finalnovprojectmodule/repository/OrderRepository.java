package com.scaler.finalnovprojectmodule.repository;

import com.scaler.finalnovprojectmodule.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderModel, String> {
    OrderModel save(OrderModel orderModel);

    @Query(value = "update 'OrderModel set OrderState='CONFIRMED where orderId = orderId", nativeQuery = true)
    OrderModel updateOrderState(long orderId);
}
