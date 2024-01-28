package com.leilaProject.contentcalendar.controller;

import com.leilaProject.contentcalendar.config.ContentCalendarProperties;
import com.leilaProject.contentcalendar.model.Content;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties  home() {
        return properties;
    }
}
