package com.ecomm.retail.ProductService.repository;

import com.ecomm.retail.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}