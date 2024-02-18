package com.ecomm.retail.PaymentService.controller;


import com.ecomm.retail.PaymentService.model.PaymentRequest;
import com.ecomm.retail.PaymentService.model.PaymentResponse;
import com.ecomm.retail.PaymentService.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        log.info("Payment initiated!!");
        return new ResponseEntity<>(paymentService.doPayment(paymentRequest),
                HttpStatus.OK);

    }
    @GetMapping("order/{orderID}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderID(@PathVariable("orderID") long Id){
        PaymentResponse paymentDetails=paymentService.getPaymentDetails(Id);
        return new ResponseEntity<>(paymentDetails, HttpStatus.OK);
    }


}
