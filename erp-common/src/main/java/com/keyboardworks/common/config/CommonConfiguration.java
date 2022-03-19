package com.keyboardworks.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyboardworks.common.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class CommonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper;
    }

    @Bean
    public JsonUtil jsonUtil(ObjectMapper objectMapper) {
        return new JsonUtil(objectMapper);
    }

}
