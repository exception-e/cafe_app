package ru.choosecafe.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.choosecafe.model.Lunch;
import ru.choosecafe.repository.LunchDataRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = LunchRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class LunchRestController
{
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "rest";

    @Autowired
    LunchDataRepository lunchDataRepository;

    @GetMapping(value = "/lunches")
    public List<Lunch> getAll() {
        log.info("getAll");
        return lunchDataRepository.getAll();
    }

    @GetMapping(value = "/admin/lunch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Lunch get(@PathVariable("id") int id) {
        log.info("get {}", id);
        return lunchDataRepository.get(id);
    }

    @PostMapping(value = "/admin/lunch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lunch> createWithLocation(@RequestBody Lunch lunch) {
        log.info("create {}", lunch);
        Lunch created = lunchDataRepository.save(lunch);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/admin/lunch/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/admin/lunch/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        log.info("delete {}", id);
        lunchDataRepository.delete(id);
    }

    @PutMapping(value = "/admin/lunch/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Lunch lunch, @PathVariable int id) {
        log.info("update {} with id={}", lunch, id);
        lunchDataRepository.save(lunch);
    }

    @GetMapping(value = "/lunch/by-restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Lunch> getByRestaurant(@RequestParam("id") Integer id) {
        log.info("getByRestaurant {}", id);
        return lunchDataRepository.getByRestaurant(id);
    }
}