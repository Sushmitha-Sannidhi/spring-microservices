package com.ecomm.retail.ProductService.service;


import com.ecomm.retail.ProductService.entity.Product;
import com.ecomm.retail.ProductService.model.ProductRequest;
import com.ecomm.retail.ProductService.model.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProduct(long id);

    void reduceQuantity(long productId, long quantity);
}
