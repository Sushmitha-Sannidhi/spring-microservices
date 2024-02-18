package com.ecomm.retail.ProductService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import java.io.Serializable;


@Entity(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long productID;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="PRICE")
    private long price;
    @Column(name="QUANTITY")
    private long quantity;
}
