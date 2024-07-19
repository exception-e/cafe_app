package graduation.choosecafe.repository;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchRepository extends JpaRepository<Lunch, Integer> {

    @Query("select l from Lunch l where l.restaurant = :restaurant")
    List<Lunch> findLunchesByRestaurant (Restaurant restaurant);
}
