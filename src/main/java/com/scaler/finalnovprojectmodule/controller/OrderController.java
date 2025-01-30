//package com.scaler.finalnovprojectmodule.controller;
//
//import com.scaler.finalnovprojectmodule.models.OrderModel;
//import com.stripe.exception.StripeException;
//import com.scaler.finalnovprojectmodule.service.OrderService;
////import com.stripe.service.climate.OrderService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.stripe.exception.StripeException;
//
//
//
//    @RestController
//    public class OrderController{
//        OrderService orderService;
//        public OrderController(OrderService orderService) {
//            this.orderService = orderService;
//        }
//
//        @PostMapping("/order")
//        public ResponseEntity<OrderModel> order(@RequestBody OrderModel ordermodel) throws StripeException {
//            return orderService.getOrder(ordermodel.getProductIdList(), ordermodel.getCustomerId(), ordermodel.getAmount());
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
