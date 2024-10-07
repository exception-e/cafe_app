package ru.choosecafe.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.dao.DataAccessException;
import ru.choosecafe.model.User;
import ru.choosecafe.model.Role;

import static ru.choosecafe.UserTestData.*;
import org.assertj.core.api.WithAssertions;
import ru.choosecafe.util.exception.NotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(locations = {
        //"classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
        })
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest implements WithAssertions{

    @Autowired
    protected UserService service;

    @Test
    void create() {
        User newUser = new User("New", "new@gmail.com", "newPass");
        User created = service.create(newUser);
        newUser.setId(created.getId());
        assertThat(service.get(created.getId())).usingRecursiveComparison().ignoringFields("roles", "password").isEqualTo(newUser);
    }

    @Test
    void delete() {
        service.delete(USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER_ID));
    }

    @Test
    void get() {
        User testUser = service.get(USER_ID);
        assertThat(testUser).usingRecursiveComparison().ignoringFields("roles", "password").isEqualTo(user);
    }

    @Test
    void getByEmail() {
        User testUser = service.loadUserByUsername("user@yandex.ru");
        assertThat(testUser).usingRecursiveComparison().ignoringFields("roles", "password").isEqualTo(user);
    }

    @Test
    void getAll() {
        List<User> all = service.getAll();
        assertThat(all).usingRecursiveComparison().ignoringFields("roles", "password").isEqualTo(users);
    }

    @Test
    void update() {
        User updated = getUpdated();
        service.update(updated);
        assertThat(service.get(USER_ID)).usingRecursiveComparison().ignoringFields("roles", "password").isEqualTo(getUpdated());
    }

    @Test
    void enable() {
        service.enable(USER_ID, false);
        assertFalse(service.get(USER_ID).isEnabled());
        service.enable(USER_ID, true);
        assertTrue(service.get(USER_ID).isEnabled());
    }

    @Test
    void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                service.create(new User(null, "Duplicate", "user@yandex.ru", "newPass", Role.USER)));
    }

    @Test
    void deletedNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(1));
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(1));
    }
}