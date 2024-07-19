package graduation.choosecafe.service;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Vote;

import java.util.List;

public interface VoteService {

    Vote create(Vote vote);
    Vote update(Vote vote);
    Vote get(Integer id);
    List<Vote> getByLunch(Lunch lunch);
    List<Vote> getByVoting(Voting voting);
}
