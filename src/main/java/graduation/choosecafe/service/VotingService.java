package graduation.choosecafe.service;

import graduation.choosecafe.model.Voting;

import java.time.LocalDate;

public interface VotingService {

    Voting create(Voting voting);
    Voting update(Voting voting);
    Voting get (Integer id);
    Voting getByDate(LocalDate date);
}
