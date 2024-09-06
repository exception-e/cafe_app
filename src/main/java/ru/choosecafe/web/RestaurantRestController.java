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
import ru.choosecafe.model.User;
import ru.choosecafe.service.LunchService;
import ru.choosecafe.service.RestaurantService;
import ru.choosecafe.to.UserTo;
import ru.choosecafe.util.exception.IllegalRequestDataException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController
{
    static final String REST_URL = "rest";
    // POST rest/admin/restaurant
    // GET rest/admin/restaurant/{id}
    // GET rest/restaurants

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping(value = "/admin/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return restaurantService.get(id);
    }

    @PostMapping(value = "/admin/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        Restaurant created = restaurantService.create(restaurant);


        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "admin/restaurant/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/admin/restaurant/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        restaurantService.delete(id);
    }

    @PutMapping(value = "/admin/restaurant/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        if (restaurant.isNew()) {
            restaurant.setId(id);
        } else if (restaurant.getId() != id) {
            throw new IllegalRequestDataException(restaurant + " must be with id=" + id);
        }
        restaurantService.update(restaurant);
    }
}