package ru.choosecafe.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.choosecafe.model.Lunch;

import java.util.List;

@Repository
public class LunchDataRepository {

    final LunchRepository lunchRepository;

    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "lunch_date");

    public LunchDataRepository(LunchRepository lunchRepository) {

        this.lunchRepository = lunchRepository;
    }

//    public Lunch save(Lunch lunch) {
//        return lunchRepository.save(lunch);
//    }


    public boolean delete(int id) {
        return lunchRepository.delete(id) != 0;
    }

    public Lunch get(int id) {
        return lunchRepository.findById(id).orElse(null);
    }


//    public List<Lunch> getByRestaurant(Integer id) {
//        return lunchRepository.findByRestaurant(id);
//    }
//
    public List<Lunch> getAll() {
        return lunchRepository.findAll(SORT_NAME_EMAIL);
    }
}
