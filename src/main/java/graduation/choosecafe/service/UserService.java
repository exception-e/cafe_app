package graduation.choosecafe.service;

import graduation.choosecafe.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);
    User getByEmail(String email);
    List<User> getAll();
    void delete(Integer id);
    User update(User user);
    User create(User user);
}
