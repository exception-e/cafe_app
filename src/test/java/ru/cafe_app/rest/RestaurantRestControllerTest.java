package ru.cafe_app.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.cafe_app.LunchTestData;
import ru.cafe_app.RestaurantTestData;
import ru.cafe_app.model.Lunch;
import ru.cafe_app.model.Restaurant;
import ru.cafe_app.repository.RestaurantDataRepository;
import ru.cafe_app.rest.json.JsonUtil;
import ru.cafe_app.util.exception.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.cafe_app.LunchTestData.lunch13;
import static ru.cafe_app.RestaurantTestData.*;
import static ru.cafe_app.UserTestData.*;

class RestaurantRestControllerTest extends AbstractRestControllerTest {

    @Autowired
    private RestaurantDataRepository repository;

    static final String RESTAURANT_URL = "/rest/restaurants/";
    static final String RESTAURANT_ADMIN_URL = "/rest/admin/restaurant/";

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(RESTAURANT_URL)
                .with(userHttpBasic(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(restaurants)));
    }

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(RESTAURANT_ADMIN_URL + joe.getId())
                .with(userHttpBasic(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(joe)));
    }

    @Test
    void createWithLocation() throws Exception {
        Restaurant newRest = RestaurantTestData.getNew();
        ResultActions actions = perform(MockMvcRequestBuilders.post(RESTAURANT_ADMIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(admin))
                .content(JsonUtil.writeValue(newRest)))
                .andExpect(status().isCreated());

        Restaurant created = JsonUtil.readValue((actions.andReturn()).getResponse().getContentAsString(), Restaurant.class );
        newRest.setId(created.getId());
        assertThat(repository.get(created.getId())).usingRecursiveComparison().isEqualTo(newRest);
    }

    //TODO
//    @Test
//    void delete() throws Exception {
//        perform(MockMvcRequestBuilders.delete(RESTAURANT_ADMIN_URL + joe.getId())
//                .with(userHttpBasic(admin)))
//                .andDo(print())
//                .andExpect(status().isNoContent());
//        assertThrows(NotFoundException.class, () -> repository.get(joe.getId()));
//    }

    @Test
    void update() throws Exception {
            Restaurant updated = RestaurantTestData.getUpdated();
            perform(MockMvcRequestBuilders.put(RESTAURANT_ADMIN_URL+"/"+joe.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .with(userHttpBasic(admin))
                    .content(JsonUtil.writeValue(updated)))
                    .andExpect(status().isNoContent());
            assertThat(repository.get(updated.getId())).usingRecursiveComparison().isEqualTo(updated);
    }
}