package com.scaler.finalnovprojectmodule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component // to mark it as a special class

public class ApplicationConfiguration {
    public RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
