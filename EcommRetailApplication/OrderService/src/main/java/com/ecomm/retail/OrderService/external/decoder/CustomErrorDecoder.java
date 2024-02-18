package com.ecomm.retail.OrderService.external.decoder;

import com.ecomm.retail.OrderService.exception.CustomException;
import com.ecomm.retail.OrderService.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        log.info(response.request().url());
        log.info(response.request().headers());

        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            throw new CustomException(
                    errorResponse.getErrorCode(),
                    response.status(),
                    errorResponse.getMessage());
        } catch (IOException e) {
            throw new CustomException("INTERNAL_SERVER_ERROR", 500, "Internal Server Error");
        }
    }
}
