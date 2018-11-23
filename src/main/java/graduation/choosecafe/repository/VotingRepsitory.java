package graduation.choosecafe.repository;

import graduation.choosecafe.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface VotingRepsitory extends JpaRepository<Voting, Integer> {

    @Query("select v from Voting v where v.date = :date")
    Voting findVotingByDate(@Param("date")LocalDate date);
}
