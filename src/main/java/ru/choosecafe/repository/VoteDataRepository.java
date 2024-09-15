package ru.choosecafe.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.choosecafe.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VoteDataRepository {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    private static final Sort SORT_DATE = Sort.by(Sort.Direction.ASC, "date");

    public VoteDataRepository(VoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository =restaurantRepository;
    }

    public List<Vote> getAll(){
        return voteRepository.findAll(SORT_DATE);
    }

    @Transactional
    public Vote save(Vote vote, int userId, int restaurant_id) {
        vote.setUser(userRepository.getReferenceById(userId));
        vote.setRestaurant(restaurantRepository.getReferenceById(restaurant_id));
        return voteRepository.save(vote);
    }

    public boolean delete(int id) {
        return voteRepository.delete(id) != 0;
    }

    public Vote get(int id) {
        return voteRepository.findById(id).orElse(null);
    }

    public List<Vote> getByDateAndUser(int userId, LocalDate date){
        return voteRepository.getByDateAndUser(userId, date);
    }

    public Integer countByRestaurantAndDate(@Param("restaurant_id") int id, @Param("date") LocalDate date){
        return voteRepository.countByRestaurantAndDate (id, date);
    }

    public Integer getWinnerRestaurantByDate(LocalDate date){
        return voteRepository.getWinnerRestaurantByDate(date);
    }
}