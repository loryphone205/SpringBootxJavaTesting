package com.leilaProject.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table (name = "CONTENT")
public record Content(
        @Id
        Integer id,
        // not blank viene da jakarta validators, vedi la documentazione. si deve aggiungere @Valid
        // al metodo in cui serve questo controllo, tipo nel create
        @NotBlank
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {

}
