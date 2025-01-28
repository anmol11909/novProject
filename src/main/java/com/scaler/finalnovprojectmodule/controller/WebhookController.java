package com.scaler.finalnovprojectmodule.controller;

import com.scaler.finalnovprojectmodule.service.PaymentService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.*;
import com.stripe.net.Webhook;
import com.stripe.service.climate.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public class WebhookController {

    private final OrderService orderService;
    PaymentService paymentService;


    public WebhookController(PaymentService paymentService, OrderService orderService) {
        this.paymentService = paymentService;
        this.orderService = orderService;
    }

    private String endpointSecret = "whsec_wRNftLajMZNeslQOP6vEPm4iVx5NlZ6z";

    private  String orderState = "I";

    @PostMapping("webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) throws SignatureVerificationException {

        try {
            Event event = Webhook.constructEvent(payload, sigHeader, endpointSecret);

            EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();
            StripeObject stripeObject = deserializer.getObject().orElse(null);

            switch (event.getType()) {
                case "payment_intent.succeeded":
                    PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
                    System.out.println("PaymentIntent was successful!");
                    System.out.println("PaymentIntent is " + paymentIntent);

                    long orderId = Long.parseLong(paymentIntent.getMetadata().get("order_id"));

                    orderState = orderState + orderService.orderStatus(orderId);

                    break;
                case "payment_method.attached":
                    PaymentMethod paymentMethod = (PaymentMethod) stripeObject;
                    System.out.println("PaymentMethod was attached to a Customer!");
                    break;
                // ... handle other event types
                default:
                    System.out.println("Unhandled event type: " + event.getType());
            }
    }
        catch (Exception ex){
            System.out.println("webhook error" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        if(orderState != null) {return ResponseEntity.ok(orderState);}
        else
            return ResponseEntity.ok("Webhook received");
    }
    public PaymentService getPaymentService() {
        return paymentService;
    }
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public String getEndpointSecret() {
        return endpointSecret;
    }
    public void setEndpointSecret(String endpointSecret) {
        this.endpointSecret = endpointSecret;
    }
    public String getOrderState() {
        return orderState;
    }
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
