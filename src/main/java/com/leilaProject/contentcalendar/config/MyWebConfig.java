package com.leilaProject.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// Configuration ci serve per specificare esplicitamente il nome della definiszione del Bean di Spring
@Configuration
public class MyWebConfig {
    //Bean ci fa capire che questo metodo ci restituisce un Bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
