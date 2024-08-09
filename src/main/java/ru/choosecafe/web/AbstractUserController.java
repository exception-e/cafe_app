package ru.choosecafe.web;

import ru.choosecafe.model.User;
import ru.choosecafe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.choosecafe.to.UserTo;
import ru.choosecafe.util.UsersUtil;

import java.util.List;

import static ru.choosecafe.UserTestData.checkNew;


public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }
    public User create(UserTo userTo) {
        log.info("create {}", userTo);
        checkNew(userTo);
        return service.create(UsersUtil.createNewFromTo(userTo));
    }



    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(UserTo userTo, int id) {
        log.info("update {} with id={}", userTo, id);
        //assureIdConsistent(userTo, id);
        service.update(userTo);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }
}