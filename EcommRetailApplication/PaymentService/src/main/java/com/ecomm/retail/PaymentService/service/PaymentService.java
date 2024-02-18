package com.ecomm.retail.PaymentService.service;

import com.ecomm.retail.PaymentService.model.PaymentRequest;
import com.ecomm.retail.PaymentService.model.PaymentResponse;

public interface PaymentService {

    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetails(long id);
}
