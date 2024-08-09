package ru.choosecafe.repository;

import ru.choosecafe.model.Lunch;
import ru.choosecafe.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Lunch, Integer> {

}
