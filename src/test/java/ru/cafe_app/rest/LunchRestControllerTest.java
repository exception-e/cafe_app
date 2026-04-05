package ru.cafe_app.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.cafe_app.model.Lunch;
import ru.cafe_app.repository.LunchDataRepository;

import ru.cafe_app.LunchTestData;
import ru.cafe_app.rest.json.JsonUtil;
import ru.cafe_app.util.exception.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.cafe_app.LunchTestData.*;
import static ru.cafe_app.UserTestData.*;

class LunchRestControllerTest extends AbstractRestControllerTest {
    @Autowired
    private LunchDataRepository repository;

    private final static String LUNCH_URL = "/rest/lunches";
    private final static String LUNCH_ADMIN_URL = "/rest/admin/lunch";


    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(LUNCH_URL)
                .with(userHttpBasic(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(lunches)));
    }

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(LUNCH_ADMIN_URL +"/"+ lunch13.getId())
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(lunch13)));
    }
//TODO

//    @Test
//    void createWithLocation() throws Exception {
//    }

    //TODO
//    @Test
//    void delete()throws Exception {
//        perform(MockMvcRequestBuilders.delete(LUNCH_ADMIN_URL+"/"+lunch13.getId())
//                .with(userHttpBasic(admin)))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//    }

    @Test
    void update() throws Exception {
        Lunch updated = LunchTestData.getUpdated();
        perform(MockMvcRequestBuilders.put(LUNCH_ADMIN_URL+"/"+lunch13.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());
        assertThat(repository.get(updated.getId())).usingRecursiveComparison().isEqualTo(updated);

    }

    @Test
    void getByRestaurant() throws Exception {
        perform(MockMvcRequestBuilders.get(LUNCH_URL+"/by-restaurant?id=100008")
                .with(userHttpBasic(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(lunches100008)));
    }

}