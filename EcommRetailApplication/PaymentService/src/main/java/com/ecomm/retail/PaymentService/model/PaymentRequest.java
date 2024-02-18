package com.ecomm.retail.PaymentService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private long orderID;
    private long amount;
    private String refNumber;
    private PaymentMode paymentMode;

}
