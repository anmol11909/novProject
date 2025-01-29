package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.models.OrderModel;
import com.scaler.finalnovprojectmodule.repository.OrderRepository;
import com.scaler.finalnovprojectmodule.repository.ProductRepository;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<OrderModel> getOrder(List<Long> productIds, long customerId, long amount) throws StripeException {
        OrderModel order = new OrderModel();
        order.setCustomerId(customerId);
        order.setAmount(amount);
        order.setProductIdList(productIds);
        orderRepository.save(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

        //WEBHOOK SERVICE TO CHANGE THE ORDER STATUS IF THE PAYMENT HAS BEEN SUCCEDED

        public String orderStatus(long orderId){
            orderRepository.updateOrderState(orderId);
            OrderModel order = new OrderModel();
            order = orderRepository.getById(String.valueOf(orderId));
            return order.toString();

    }
}
