package com.ecomm.retail.PaymentService.repository;

import com.ecomm.retail.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetails,Long> {
    TransactionDetails findByOrderID(long orderID);


}

