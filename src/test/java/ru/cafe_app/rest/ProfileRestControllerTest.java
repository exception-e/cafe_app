package ru.cafe_app.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.cafe_app.rest.json.JsonUtil;
import ru.cafe_app.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static ru.cafe_app.UserTestData.*;

class ProfileRestControllerTest extends AbstractRestControllerTest {

    @Autowired
    private UserService userService;
    static final String USER_URL = "/rest/profile/";

    @Test
    void get() throws Exception{
        perform(MockMvcRequestBuilders.get(USER_URL)
                .with(userHttpBasic(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(JsonUtil.writeValue(user)));

    }

    @Test
    void delete() throws Exception{
            perform(MockMvcRequestBuilders.delete(USER_URL)
                    .with(userHttpBasic(user)))
                    .andExpect(status().isNoContent());
    }

    @Test
    void register() {
    }

    @Test
    void update() {
    }
}