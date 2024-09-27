package ru.choosecafe.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.choosecafe.model.Restaurant;
import ru.choosecafe.repository.RestaurantDataRepository;

import java.net.URI;
import java.util.List;

import static ru.choosecafe.UserTestData.assureIdConsistent;

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController
{
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "rest";

    @Autowired
    RestaurantDataRepository restaurantDataRepository;

    @GetMapping(value = "/restaurants")
    public List<Restaurant> getAll() {
        log.info("getAll");
        return restaurantDataRepository.getAll();
    }

    @GetMapping(value = "/admin/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        log.info("get {}", id);
        return restaurantDataRepository.get(id);
    }

    @PostMapping(value = "/admin/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        log.info("create {}", restaurant);
        Restaurant created = restaurantDataRepository.save(restaurant);


        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "admin/restaurant/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/admin/restaurant/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        log.info("delete {}", id);
        restaurantDataRepository.delete(id);
    }

    @PutMapping(value = "/admin/restaurant/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        log.info("update {} with id={}", restaurant, id);
        assureIdConsistent(restaurant, id);
        restaurantDataRepository.save(restaurant);
    }
}