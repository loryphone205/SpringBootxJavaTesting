package com.leilaProject.contentcalendar.controller;

import com.leilaProject.contentcalendar.model.Content;
import com.leilaProject.contentcalendar.model.Status;
import com.leilaProject.contentcalendar.repository.ContentCollectionRepository;
import com.leilaProject.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    // fai una richiesta e prendi tutti i pezzi di content che trovi nel sistema
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    //CRUD
    //read singolo elemento
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun Contenuto"));
    }

    //create, aggiungo una http response così si capisce meglio
    // aggiungo @Valid
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    //update, si fa con il PutMapping, sempre per l'id, però questa votla senza rispota tanto per
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        //controlliamo se esiste già l'ememento con questo id oppure no
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non esistente");
        }
        //salviamo
        repository.save(content);
    }

    //delete con risposta
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle (@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus (@PathVariable Status status) {
        return repository.listByStatus(status);
    }

}
