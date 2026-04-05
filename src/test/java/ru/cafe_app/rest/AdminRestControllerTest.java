package ru.cafe_app.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.cafe_app.model.User;
import ru.cafe_app.rest.json.JsonUtil;
import ru.cafe_app.service.UserService;
import ru.cafe_app.util.exception.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.cafe_app.UserTestData.*;

class AdminRestControllerTest extends AbstractRestControllerTest {

    @Autowired
    private UserService userService;

    private static final String ADMIN_URL = "/rest/admin/users/";


    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(ADMIN_URL)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(users)));
    }

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(ADMIN_URL + ADMIN_ID)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(admin)));
    }

    @Test
    void getByMail() throws Exception {
        perform(MockMvcRequestBuilders.get(ADMIN_URL + "by-email?email=" + user.getEmail())
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andExpect(content().json(JsonUtil.writeValue(user)));
    }

    @Test
    void getNotAuth() throws Exception {
        perform(MockMvcRequestBuilders.get(ADMIN_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void createWithLocation() throws Exception {
        User newUser = getNew();
        ResultActions actions = perform(MockMvcRequestBuilders.post(ADMIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeAdditionProps(newUser, "password", newUser.getPassword())))
                .andExpect(status().isCreated());

        User created = JsonUtil.readValue((actions.andReturn()).getResponse().getContentAsString(), User.class );
        newUser.setId(created.getId());
        assertThat(userService.get(created.getId())).usingRecursiveComparison().ignoringFields("roles", "password").isEqualTo(newUser);
    }


    //TODO
    @Test
    void createDuplicated() throws Exception {

    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(ADMIN_URL +USER_ID)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> userService.get(USER_ID));
    }

    @Test
    void update() throws Exception {
        User updated = getUpdated();
        perform(MockMvcRequestBuilders.put(ADMIN_URL + USER_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeAdditionProps(updated, "password", updated.getPassword())))
                .andExpect(status().isNoContent());
        assertThat(userService.get(updated.getId())).usingRecursiveComparison().ignoringFields( "password").isEqualTo(updated);

    }

    @Test
    void enable() throws Exception {
        perform(MockMvcRequestBuilders.patch(ADMIN_URL + USER_ID)
                .param("enabled", "false")
                .content(MediaType.APPLICATION_JSON_VALUE)
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertFalse(userService.get(USER_ID).isEnabled());
    }
}