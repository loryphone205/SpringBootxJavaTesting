package com.leilaProject.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties (String welcomeMessage, String about){

}
