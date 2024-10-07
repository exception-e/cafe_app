package ru.choosecafe;

import ru.choosecafe.model.Role;
import ru.choosecafe.model.User;

import java.util.Collections;
import java.util.List;

import static ru.choosecafe.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User user = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN, Role.USER);
    public static final User user0 = new User(100002, "User0", "user0@gmail.com", "user0", Role.USER);
    public static final User user1 = new User(100003, "User1", "user1@gmail.com", "user1", Role.USER);
    public static final User user2 = new User(100004, "User2", "user2@gmail.com", "user2", Role.USER);
    public static final User user3 = new User(100005, "User3", "user3@gmail.com", "user3", Role.USER);
    public static final User user4 = new User(100006, "User4", "user4@gmail.com", "user4", Role.USER);
    public static final User user5 = new User(100007, "User5", "user5@gmail.com", "user5", Role.USER);

    public  static  final List<User> users = List.of(admin, user, user0, user1, user2, user3, user4, user5);

    public static User getUpdated() {
        User updated = new User(user);
        updated.setName("UpdatedName");
        updated.setPassword("newPass");
        updated.setEnabled(false);
        updated.setRoles(Collections.singleton(Role.ADMIN));
        return updated;
    }
}