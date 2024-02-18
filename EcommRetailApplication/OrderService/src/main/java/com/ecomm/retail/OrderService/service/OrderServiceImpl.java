package com.ecomm.retail.OrderService.service;

import com.ecomm.retail.OrderService.entity.Order;
import com.ecomm.retail.OrderService.exception.CustomException;
import com.ecomm.retail.OrderService.external.client.PaymentService;
import com.ecomm.retail.OrderService.external.client.ProductService;
import com.ecomm.retail.OrderService.external.request.PaymentRequest;
import com.ecomm.retail.OrderService.external.response.PaymentResponse;
import com.ecomm.retail.OrderService.model.OrderRequest;
import com.ecomm.retail.OrderService.model.OrderResponse;
import com.ecomm.retail.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.Instant;


@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Placing order=>{}", orderRequest);

        productService.reduceOuantity(orderRequest.getProductID(), orderRequest.getQuantity());

        log.info("Creating order.......");
        Order order = Order.builder()
                .productID(orderRequest.getProductID())
                .quantity(orderRequest.getQuantity())
                .amount(orderRequest.getTotalAmount())
                .orderDate(Instant.now())
                .orderStatus("Order Created")
                .build();

        log.info(order);

        orderRepository.save(order);
        log.info("Order placed successfully with OrderID:{}", order.getOrderID());

        log.info("Calling payment service to complete the payment!!");
        PaymentRequest paymentRequest= PaymentRequest.builder().orderID(order.getOrderID())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getTotalAmount())
                .build();

        String orderStatus=null;
        try{
            paymentService.doPayment(paymentRequest);
            log.info("Payment is success!!");
            orderStatus="Order Placed";
        } catch(Exception e){
            log.info("Error occurred during payment!!");
            orderStatus="Order not placed";
        }

        log.info("Order status for order ID-{} updated to {}",order.getOrderID(),orderStatus);

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);

        return order.getOrderID();
    }

    @Override
    public OrderResponse getOrderDetails(long orderID) {
        log.info("Getting the order details for orderID: {}",orderID);
       Order order=orderRepository.findById(orderID).orElseThrow(
                ()-> new CustomException("ORDER_NOT_FOUND",404,"Order does not exist for oderId:"+orderID)
        );

       OrderResponse.ProductDetails productDetails=restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+order.getProductID(),OrderResponse.ProductDetails.class);
       PaymentResponse paymentResponse= restTemplate.getForObject("http://PAYMENT-SERVICE/payment/order/"+order.getOrderID(), PaymentResponse.class);
       return OrderResponse.builder()
               .orderID(orderID)
               .orderDate(order.getOrderDate())
               .orderStatus(order.getOrderStatus())
               .amount(order.getAmount())
               .productDetails(productDetails)
               .paymentDetails(paymentResponse).build();
    }
}
