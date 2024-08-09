package ru.choosecafe.service;

import ru.choosecafe.model.Lunch;
import ru.choosecafe.repository.LunchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunchService {

    private final LunchRepository repository;

    public LunchService(LunchRepository repository)
    {
        this.repository = repository;
    }

    public List<Lunch> getAll() {
        return repository.findAll();
    }
    public Lunch get(Integer id) {
        return repository.getOne(id);
    }

    public void delete(Integer id) {
            repository.deleteById(id);
    }

    public Lunch create(Lunch lunch) {
        return repository.save(lunch);
    }

    public Lunch update(Lunch lunch) {
        return repository.save(lunch);
    }

    public List<Lunch> getByRestaurant(Integer id) {

        return repository.findByRestaurant(id);
    }
}
