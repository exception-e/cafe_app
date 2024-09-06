package ru.choosecafe.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import ru.choosecafe.model.Restaurant;
import ru.choosecafe.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("select v from Vote v where v.restaurant.id = :restaurant_id and v.date = :date")
    List<Vote> getByRestaurant(@Param("restaurant_id") int id, @Param("date") LocalDate date);

    @Query("select count (*) from Vote v where v.restaurant.id = :restaurant_id and v.date = :date")
    Long countByRestaurant(@Param("restaurant_id") int id, @Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);
}