package graduation.choosecafe.repository;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LunchRepository extends JpaRepository<Lunch, Integer> {

    @Query("select l from Lunch l where l.voting = :voting")
    List<Lunch> fildLunchesbyVoting (Voting voting);
}
