package graduation.choosecafe.repository;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Restaurant;
import graduation.choosecafe.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {


    @Query("select v from Vote v where v.restaurant = :restaurant")
    List<Vote> findVotesByRestaurant(@Param("restaurant") Restaurant restaurant);

}
