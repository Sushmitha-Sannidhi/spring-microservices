package com.ecomm.retail.OrderService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private long productID;
    private long totalAmount;
    private long quantity;
    private PaymentMode paymentMode;
}
