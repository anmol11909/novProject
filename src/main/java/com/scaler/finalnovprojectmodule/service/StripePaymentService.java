package com.scaler.finalnovprojectmodule.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;

public class StripePaymentService implements PaymentService {

    private final OrderService orderService;
    public StripePaymentService(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public String makePayment(long orderId, long amount) throws StripeException {
        Stripe.apiKey = "sk_test_51QlaoNBLQGaqYkggxKoiutkb5hT1AmecY3EdnIKb9TLhOn8xrdlk09T80l61Mu12XWMGAedAh3ynvIQzkZQnuLia00MNP00f1w";


        //1.) CREATE PAYMENT INTENT WITH META DATA

        PaymentIntentCreateParams intentParams = PaymentIntentCreateParams.builder().setAmount(amount)
                .setCurrency("INR")
                .putMetadata("order_id", String.valueOf(orderId))
                .build();
        PaymentIntent paymentIntent = PaymentIntent.create(intentParams);




        //2.)CREATING PRICE OBJECT

        PriceCreateParams params =
                PriceCreateParams.builder().setCurrency("INR")
                        .setUnitAmount(amount)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName(String.valueOf(orderId)).build()
                        )
                        .build();

        Price price = Price.create(params);

        //3.) CREATING PAYMENT LINK BY using THE PRICE OBJECT AND PAYMENTINTENT METADATA

        PaymentLinkCreateParams linkParams =
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

                        .putMetadata("order_id", String.valueOf(orderId))
                        .putMetadata("payment_intent_id", paymentIntent.getId())
                        .build();

        PaymentLink paymentLink = PaymentLink.create(linkParams);

        String paymentLinkUrl = paymentLink.getUrl();
        String paymentIntentId = paymentIntent.getId();

        return paymentLinkUrl + " " + paymentIntentId;

    }
}
