package graduation.choosecafe.service;

import graduation.choosecafe.model.User;
import graduation.choosecafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public User get(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public User create(User user) {
        return repository.saveAndFlush(user);
    }
}
