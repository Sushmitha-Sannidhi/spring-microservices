package com.ecomm.retail.OrderService.model;

import com.ecomm.retail.OrderService.external.response.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private long orderID;
    private String orderStatus;
    private long amount;
    private Instant orderDate;
    private ProductDetails productDetails;
    private PaymentResponse paymentDetails;

    @Data
    @Builder
    public static class ProductDetails {
        private long id;
        private String name;
        private long quantity;
        private long price;
    }
}
