package com.ecomm.retail.OrderService.external.request;


import com.ecomm.retail.OrderService.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private long orderID;
    private long amount;
    private String refNumber;
    private PaymentMode paymentMode;

}
