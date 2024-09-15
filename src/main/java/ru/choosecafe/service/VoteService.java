package ru.choosecafe.service;

import ru.choosecafe.model.Vote;
import ru.choosecafe.repository.VoteDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoteService {

    private final VoteDataRepository repository;

    @Autowired
    public VoteService(VoteDataRepository repository) {
        this.repository = repository;
    }

    public Vote create(Vote vote, int user_id, int restaurant_id) {
        return repository.save(vote, user_id, restaurant_id);
    }

    public Vote update(Vote vote, int user_id, int restaurant_id) {
        return repository.save(vote, user_id, restaurant_id);
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

    public Integer countByRestaurantAndDate(Integer id, LocalDate date){
        return repository.countByRestaurantAndDate(id, date);
    }

    public Integer getWinnerRestaurantByDate(LocalDate date){
        return repository.getWinnerRestaurantByDate(date);
    }

    public List<Vote> getByDateAndUser(Integer userId, LocalDate date) {
        return repository.getByDateAndUser(userId, date);
    }
}
