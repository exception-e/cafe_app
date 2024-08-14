package ru.choosecafe.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.choosecafe.model.Lunch;
import ru.choosecafe.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantDataRepository {

    final RestaurantRepository restaurantRepository;
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    public RestaurantDataRepository(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll(){
        return restaurantRepository.findAll(SORT_NAME);
    }

    public Restaurant save (Restaurant r){
        return restaurantRepository.save(r);
    }


    public boolean delete(int id) {
        return restaurantRepository.delete(id) != 0;
    }

    public Restaurant get(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }

}
