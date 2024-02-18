package com.ecomm.retail.OrderService.controller;

import com.ecomm.retail.OrderService.model.OrderRequest;
import com.ecomm.retail.OrderService.model.OrderResponse;
import com.ecomm.retail.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        long orderID=orderService.placeOrder(orderRequest);
        return  new ResponseEntity<>(orderID, HttpStatus.ACCEPTED);
    }
@GetMapping("/{orderID}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long orderID){
        return new ResponseEntity(orderService.getOrderDetails(orderID),HttpStatus.OK);
    }
}
