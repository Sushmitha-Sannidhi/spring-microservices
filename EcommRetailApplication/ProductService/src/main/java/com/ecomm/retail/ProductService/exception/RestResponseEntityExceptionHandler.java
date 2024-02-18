package com.ecomm.retail.ProductService.exception;

import com.ecomm.retail.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handling for product controller class
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
       @ExceptionHandler(ProductServiceCustomException.class)
       public ResponseEntity<ErrorResponse>  handleResponseEntityException(ProductServiceCustomException productServiceCustomException){
              ErrorResponse response= ErrorResponse.builder()
                      .message(productServiceCustomException.getMessage())
                      .errorCode(productServiceCustomException.getErrorCode()).build();
              return new ResponseEntity(response, HttpStatus.NOT_FOUND);


       }
}
