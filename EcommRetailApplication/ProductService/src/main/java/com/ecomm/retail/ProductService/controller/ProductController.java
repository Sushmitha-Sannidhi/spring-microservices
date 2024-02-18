package com.ecomm.retail.ProductService.controller;


import com.ecomm.retail.ProductService.model.ProductRequest;
import com.ecomm.retail.ProductService.model.ProductResponse;
import com.ecomm.retail.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

   @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
          long productID=productService.addProduct(productRequest);
          return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") long Id){
        ProductResponse product=productService.getProduct(Id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceOuantity(@PathVariable("id") long productId,@RequestParam long quantity){
       productService.reduceQuantity(productId,quantity);
       return new ResponseEntity<>(HttpStatus.OK);

    }
}
