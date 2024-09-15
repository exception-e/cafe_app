package ru.choosecafe.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import ru.choosecafe.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("select v from Vote v where v.user.id = :user_id and v.date = :date")
    List<Vote> getByDateAndUser(@Param("user_id") int id, @Param("date") LocalDate date);

    @Query(value ="select count(*), uidm.restaurant_id from" +
                    " (select user_id, date, restaurant_id, max(time) from vote" +
                    " where restaurant_id = ?1 and date = ?2 group by user_id, date, restaurant_id) as uidm" +
                    " group by uidm.restaurant_id;", nativeQuery = true)
    Integer countByRestaurantAndDate(@Param("restaurant_id") int id, @Param("date") LocalDate date);

    @Query(value = "select restaurant_id from" +
            " (select count(*) as vote_count, uidm.restaurant_id from" +
            " (select user_id, date, restaurant_id, max(time) from vote" +
            " where date=?1 group by user_id, date, restaurant_id) as uidm" +
            " group by uidm.restaurant_id order by vote_count desc limit 1) as winner", nativeQuery = true)
    Integer getWinnerRestaurantByDate(@Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);
}