package graduation.choosecafe.repository;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Vote;
import graduation.choosecafe.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {


    @Query("select v from Vote v where v.lunch = :lunch")
    List<Vote> findVotesByLunch(@Param("lunch") Lunch lunch);


    @Query("select v from Vote v where v.voting = :voting")
    List<Vote> findVotesByVoting(@Param("voting") Voting voting);
}
