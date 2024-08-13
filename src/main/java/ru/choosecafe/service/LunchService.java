package ru.choosecafe.service;

import ru.choosecafe.model.Lunch;
import ru.choosecafe.repository.LunchDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunchService {

    private final LunchDataRepository repository;

    public LunchService(LunchDataRepository repository)
    {
        this.repository = repository;
    }

    public List<Lunch> getAll() {
        return repository.getAll();
    }

    public Lunch get(Integer id) {
        return repository.get(id);
    }

    public boolean delete(Integer id) {
            return repository.delete(id);
    }

    public Lunch create(Lunch lunch) {
        return repository.save(lunch);
    }

    public Lunch update(Lunch lunch) {
        return repository.save(lunch);
    }

    public List<Lunch> getByRestaurant(Integer id) {
        return repository.getByRestaurant(id);
    }
}
