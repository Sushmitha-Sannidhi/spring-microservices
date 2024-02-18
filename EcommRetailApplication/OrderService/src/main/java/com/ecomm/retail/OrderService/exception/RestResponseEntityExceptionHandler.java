package com.ecomm.retail.OrderService.exception;


import com.ecomm.retail.OrderService.external.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handling for product controller class
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
       @ExceptionHandler(CustomException.class)
       public ResponseEntity<ErrorResponse>  handleResponseEntityException(CustomException customException){
              ErrorResponse response= ErrorResponse.builder()
                      .message(customException.getMessage())
                      .errorCode(customException.getErrorCode()).build();
              return new ResponseEntity(response, HttpStatusCode.valueOf(customException.getStatus()));


       }
}
