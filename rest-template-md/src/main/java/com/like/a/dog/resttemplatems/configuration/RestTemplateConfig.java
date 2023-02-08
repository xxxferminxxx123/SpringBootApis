package com.like.a.dog.resttemplatems.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.like.a.dog.resttemplatems.dto.UserDTO;

@Configuration
public class RestTemplateConfig {

    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }


	
}
