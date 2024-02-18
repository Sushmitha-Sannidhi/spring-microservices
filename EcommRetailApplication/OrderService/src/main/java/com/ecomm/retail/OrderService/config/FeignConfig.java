package com.ecomm.retail.OrderService.config;

import com.ecomm.retail.OrderService.external.decoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    ErrorDecoder errordecoder(){
        return new CustomErrorDecoder();
    }
}
