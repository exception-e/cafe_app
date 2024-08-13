package ru.choosecafe.repository;

import org.springframework.stereotype.Repository;
import ru.choosecafe.model.Restaurant;

@Repository
public class RestaurantDataRepository {

    final RestaurantRepository restaurantRepository;

    public RestaurantDataRepository(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;
    }

    public boolean delete(int id) {
        return restaurantRepository.delete(id) != 0;
    }

    public Restaurant get(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }

}
