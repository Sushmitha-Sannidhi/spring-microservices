package com.ecomm.retail.PaymentService.model;

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
