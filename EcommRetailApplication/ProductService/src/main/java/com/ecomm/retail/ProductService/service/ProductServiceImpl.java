package com.ecomm.retail.ProductService.service;


import com.ecomm.retail.ProductService.entity.Product;
import com.ecomm.retail.ProductService.exception.ProductServiceCustomException;
import com.ecomm.retail.ProductService.model.ProductRequest;
import com.ecomm.retail.ProductService.model.ProductResponse;
import com.ecomm.retail.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product!!");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product created"+product.getProductID());

        return product.getProductID();
    }

    @Override
    public ProductResponse getProduct(long id) {
        log.info("Getting the product for product ID:{}",id);
        Product product=productRepository.findById(id).orElseThrow(()->new ProductServiceCustomException("Requested product ID not found in the table!!","Product_Not_Found"));
        return ProductResponse.builder()
               .id(product.getProductID())
               .name(product.getProductName())
               .quantity(product.getQuantity())
               .price(product.getPrice()).build();

    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce quantity {} for ID:{}",quantity,productId);
        Product product=productRepository.findById(productId).orElseThrow(
                ()-> new ProductServiceCustomException("Product ID not found","PRODUCT_NOT_FOUND")
        );

        if(product.getQuantity()<quantity)
            throw new ProductServiceCustomException("Product does not have sufficient quantity!","OUT_OF_STOCK");
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);

        log.info("Product quantity reduced successfully!!");
    }
}

