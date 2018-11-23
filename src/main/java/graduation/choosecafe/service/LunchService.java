package graduation.choosecafe.service;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Voting;

import java.util.List;

public interface LunchService {

    Lunch get(Integer id);
    void delete(Integer id);
    Lunch create(Lunch lunch);
    Lunch update(Lunch lunch);
    List<Lunch> getByVoting(Voting voting);
}
