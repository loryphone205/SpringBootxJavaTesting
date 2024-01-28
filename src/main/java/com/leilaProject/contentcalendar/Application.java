package com.leilaProject.contentcalendar;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.leilaProject.contentcalendar.config.ContentCalendarProperties;
import com.leilaProject.contentcalendar.model.Content;
import com.leilaProject.contentcalendar.model.Status;
import com.leilaProject.contentcalendar.model.Type;
import com.leilaProject.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*
        questo sotto è giusto per vedere tutti i bean usati
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        */
        /* Esempio di come usare un bean per prendree un restTempalte?
        RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
        System.out.println(restTemplate);
        */
        SpringApplication.run(Application.class, args);

        }



}
