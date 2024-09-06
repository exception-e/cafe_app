package ru.choosecafe.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.choosecafe.model.Lunch;
import ru.choosecafe.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VoteDataRepository {

    final VoteRepository voteRepository;

    private static final Sort SORT_DATE = Sort.by(Sort.Direction.ASC, "date");

    public VoteDataRepository(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAll(){
        return voteRepository.findAll(SORT_DATE);
    }

    public Vote save (Vote v){
        return voteRepository.save(v);
    }

    public boolean delete(int id) {
        return voteRepository.delete(id) != 0;
    }

    public Vote get(int id) {
        return voteRepository.findById(id).orElse(null);
    }

    public List<Vote> getByRestaurant(Integer id, LocalDate date) {
        return voteRepository.getByRestaurant(id, date);
    }
}