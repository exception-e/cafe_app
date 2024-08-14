package ru.choosecafe.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.choosecafe.model.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional(readOnly = true)
public interface LunchRepository extends JpaRepository<Lunch, Integer> {

    @Query("select l from Lunch l where l.restaurant.id = :restaurant_id")
    List<Lunch> getByRestaurant (@Param("restaurant_id")Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Lunch l WHERE l.id=:id")
    int delete(@Param("id") int id);

}
