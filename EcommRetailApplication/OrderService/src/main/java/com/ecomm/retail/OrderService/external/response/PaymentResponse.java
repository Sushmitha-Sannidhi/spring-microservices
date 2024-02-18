package com.ecomm.retail.OrderService.external.response;

import com.ecomm.retail.OrderService.model.PaymentMode;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PaymentResponse {
    private long paymentID;
    private String paymentStatus;
    private long orderID;
    private Instant paymentDate;
    private long amount;
    private PaymentMode paymentMode;
}
