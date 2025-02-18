package com.demo_project.DemoProject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class SpringBeanConfiguration {

    @Bean
    public ModelMapper objectMapper() {
        return new ModelMapper();
    }
}
