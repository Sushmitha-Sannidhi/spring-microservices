package com.ecomm.retail.PaymentService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Entity
@Table(name="TRANSACTION_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="ORDER_ID")
    private long orderID;
    @Column(name="MODE")
    private String paymentMode;
    @Column(name="REF_NUM")
    private String referenceNumber;
    @Column(name="DATE")
    private Instant paymentDate;
    @Column(name="STATUS")
    private String paymentStatus;
    @Column(name="AMOUNT")
    private long amount;

}
