package ru.choosecafe.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.choosecafe.model.User;

import java.util.List;

@Repository
public class UserDataRepository {

    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");
    UserRepository userRepository;
    public UserDataRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(int id) {
        return userRepository.delete(id) != 0;
    }

    public User get(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public List<User> getAll() {
        return userRepository.findAll(SORT_NAME_EMAIL);
    }
}