package com.ecomm.retail.PaymentService.service;


import com.ecomm.retail.PaymentService.entity.TransactionDetails;
import com.ecomm.retail.PaymentService.exception.CustomPaymentException;
import com.ecomm.retail.PaymentService.model.PaymentMode;
import com.ecomm.retail.PaymentService.model.PaymentRequest;
import com.ecomm.retail.PaymentService.model.PaymentResponse;
import com.ecomm.retail.PaymentService.repository.TransactionDetailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording transaction details:{}", paymentRequest);
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .orderID(paymentRequest.getOrderID())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .amount(paymentRequest.getAmount())
                .referenceNumber(paymentRequest.getRefNumber())
                .paymentStatus("SUCCESS")
                .build();

        transactionDetailRepository.save(transactionDetails);
        log.info("Transaction completed with id:{}", transactionDetails.getId());
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetails(long id) {
        log.info("Getting the payment details using orderID, {}",id);
        TransactionDetails transactionDetails = transactionDetailRepository.findByOrderID(id);

        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentID(id)
                .paymentStatus(transactionDetails.getPaymentStatus())
                .orderID(transactionDetails.getOrderID())
                .amount(transactionDetails.getAmount())
                .paymentDate(transactionDetails.getPaymentDate())
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .build();

        return paymentResponse;
    }
}
