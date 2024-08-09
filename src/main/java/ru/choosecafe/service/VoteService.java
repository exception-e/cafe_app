package ru.choosecafe.service;

import ru.choosecafe.model.Restaurant;
import ru.choosecafe.model.Vote;
import ru.choosecafe.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote create(Vote vote) {
        return repository.saveAndFlush(vote);
    }

    public Vote update(Vote vote) {
        return repository.saveAndFlush(vote);
    }

    public Vote get(Integer id) {
        return repository.getOne(id);
    }

    public List<Vote> getByRestaurant(Restaurant restaurant)
    {
        return repository.findVotesByRestaurant(restaurant);
    }
}
