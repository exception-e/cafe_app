package ru.choosecafe.service;


import org.springframework.core.env.Environment;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations =
        "classpath:spring/spring-mvc.xml"
)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))

public class UserServiceTest {
    @Autowired
    private Environment env;

//    @Autowired
//    protected UserService service;

    //@Autowired
    //private CacheManager cacheManager;

    @BeforeEach
    void setUp() throws Exception {
       // cacheManager.getCache("users").clear();
    }

//    @Test
//    void create() throws Exception {
//        User newUser = new User("New", "new@gmail.com", "newPass");
//        User created = service.create(newUser);
//        newUser.setId(created.getId());
//        assertMatch(service.getAll(),  USER, ADMIN, newUser);
//    }
//
//    @Test
//    void getAll() throws Exception {
//        List<User> all = service.getAll();
//        assertMatch(all, USER, ADMIN);
//    }

    /*@Test
    void duplicateMailCreate() throws Exception {
        assertThrows(DataAccessException.class, () ->
                service.create(new User(null, "Duplicate", "user@yandex.ru", "newPass", Role.ROLE_USER)));
    }*/

//    @Test
//    void update() throws Exception {
//        User updated = new User(USER);
//        updated.setName("UpdatedName");
//        service.update(new User(updated));
//        assertMatch(service.get(USER_ID), updated);
//    }
//
//    @Test
//    void delete() throws Exception {
//        service.delete(USER_ID);
//        assertMatch(service.getAll(), ADMIN);
//    }

    /*@Test
    void deletedNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.delete(1));
    }*/

//    @Test
//    void get() throws Exception {
//        User user = service.get(ADMIN_ID);
//        assertMatch(user, ADMIN);
//    }

    /*@Test
    void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.get(1));
    }

    @Test
    void getByEmail() throws Exception {
        User user = service.getByEmail("admin@gmail.com");
        assertMatch(user, ADMIN);
    }





    @Test
    void enable() {
        service.enable(USER_ID, false);
        assertFalse(service.get(USER_ID).isEnabled());
        service.enable(USER_ID, true);
        assertTrue(service.get(USER_ID).isEnabled());
    }*/
}