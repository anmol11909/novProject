package com.scaler.finalnovprojectmodule.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService {

   // private final OrderService orderService;
//    public StripePaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }


    @Override
    public String makePayment(String orderId, long amount) throws StripeException {
        Stripe.apiKey = "sk_test_51Qg2kJAZYzBCgUSnYCkMjztHsemNLhMtRIuYHfzFimFdw3kc1Swgk3mJTYR1JCn0r9xrJX7uoawX5NosXIiozwsV00MV5A7xCp";

        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(amount)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                        )
                        .build();

        Price price = Price.create(params);


        //CREATE PAYMENT LINK

        PaymentLinkCreateParams linkParam =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        ).setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://scaler.com")
                                                        .build()
                                        )
                                        .build()
                        )
                        .putMetadata("order_id", orderId)
                        .build();

        PaymentLink paymentLink = PaymentLink.create(linkParam);

        String paymentLinkUrl = paymentLink.getUrl();

        return paymentLinkUrl;
    }

}
