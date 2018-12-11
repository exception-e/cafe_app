package graduation.choosecafe.service;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Vote;
import graduation.choosecafe.model.Voting;
import graduation.choosecafe.repository.LunchRepository;
import graduation.choosecafe.repository.VoteRepository;
import graduation.choosecafe.repository.VotingRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VotingServiceImpl implements VotingService {

    private final VotingRepsitory repsitory;
    private final LunchRepository lunchRepository;
    private final VoteRepository voteRepository;

    @Autowired
    public VotingServiceImpl(VotingRepsitory repsitory, LunchRepository lunchRepository, VoteRepository voteRepository)
    {
        this.repsitory = repsitory;
        this.lunchRepository = lunchRepository;
        this.voteRepository = voteRepository;

    }

    @Override
    public Voting create(Voting voting) {
        return repsitory.save(voting);
    }

    @Override
    public Voting update(Voting voting) {
        return repsitory.save(voting);
    }

    @Override
    public Voting get(Integer id) {
        return repsitory.getOne(id);
    }

    @Override
    public Voting getByDate(LocalDate date) {
        return repsitory.findVotingByDate(date);
    }

    public Lunch getResult(Voting voting)
    {
        Map<Lunch, Long> map = voteRepository.findVotesByVoting(voting).stream().collect
            (Collectors.groupingBy(Vote:: getLunch, Collectors.counting()));

        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();


    }
}
