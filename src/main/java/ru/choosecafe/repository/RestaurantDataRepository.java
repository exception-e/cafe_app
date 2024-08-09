package ru.choosecafe.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDataRepository {

    final RestaurantRepository restaurantRepository;

    public RestaurantDataRepository(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;
    }
}
