package ru.choosecafe.service;

import ru.choosecafe.model.Vote;
import ru.choosecafe.repository.VoteDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteDataRepository repository;

    @Autowired
    public VoteService(VoteDataRepository repository) {
        this.repository = repository;
    }

    public Vote create(Vote vote) {
        return repository.save(vote);
    }

    public Vote update(Vote vote) {
        return repository.save(vote);
    }

    public Vote get(Integer id) {
        return repository.get(id);
    }

    public List<Vote> getAll() {
        return repository.getAll();
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public List<Vote> getByRestaurant(Integer id)
    {
        return repository.getByRestaurant(id);
    }
}
