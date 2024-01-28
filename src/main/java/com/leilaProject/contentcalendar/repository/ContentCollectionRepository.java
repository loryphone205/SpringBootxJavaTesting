package com.leilaProject.contentcalendar.repository;

import com.leilaProject.contentcalendar.model.Status;
import com.leilaProject.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import com.leilaProject.contentcalendar.model.Content;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    //creiamo una lsita
    private final List<Content> contentList = new ArrayList<>();

    //costruttore
    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        //in poche parole, cerco l'id e ritorno il tipo optional, alla prima occorrenza
        //optional ci permette di gestire anche il caso di Null
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    public void init() {
        Content c = new Content(
                1,
                "My First Video",
                "This is a descritpion",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(c);
    }

    //ci serve per controllare se esiste per id l'elemento che stiamo cercando
    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
