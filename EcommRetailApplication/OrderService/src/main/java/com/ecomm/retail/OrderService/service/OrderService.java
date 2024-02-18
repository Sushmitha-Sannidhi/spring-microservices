package com.ecomm.retail.OrderService.service;

import com.ecomm.retail.OrderService.model.OrderRequest;
import com.ecomm.retail.OrderService.model.OrderResponse;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    long  placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderID);
}
