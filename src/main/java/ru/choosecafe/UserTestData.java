package ru.choosecafe;

import ru.choosecafe.model.AbstractBaseEntity;
import ru.choosecafe.model.Role;
import ru.choosecafe.model.User;

public class UserTestData {
    public static final int USER_ID = AbstractBaseEntity.START_SEQ;
    public static final int ADMIN_ID = AbstractBaseEntity.START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);

    public static final User ADMIN = new User(ADMIN_ID,"Admin", "admin@gmail.com", "admin", Role.ADMIN, Role.USER);

//    public static void assertMatch(User actual, User expected) {
//        assertThat(actual).isEqualToIgnoringGivenFields(expected, "roles");
//    }

//    public static void assertMatch(Iterable<User> actual, User... expected) {
//        assertMatch(actual, Arrays.asList(expected));
//    }

//    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
//        assertThat(actual).isEqualTo(expected);
//    }

    /*public static ResultMatcher contentJson(User... expected) {
        return content().json(writeIgnoreProps(Arrays.asList(expected), "registered"));
    }

    public static ResultMatcher contentJson(User expected) {
        return content().json(writeIgnoreProps(expected, "registered"));
    }*/

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalArgumentException(bean + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(AbstractBaseEntity bean, int id) {
//      http://stackoverflow.com/a/32728226/548473
        if (bean.isNew()) {
            bean.setId(id);
        } else if (bean.getId() != id) {
            throw new IllegalArgumentException(bean + " must be with id=" + id);
        }
    }
}