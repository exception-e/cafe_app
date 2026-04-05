package ru.cafe_app;

import ru.cafe_app.model.Lunch;
import ru.cafe_app.model.Restaurant;
import ru.cafe_app.model.Role;
import ru.cafe_app.model.User;

import java.util.Collections;
import java.util.List;

public class RestaurantTestData {

    public static final Restaurant joe = new Restaurant(100008, "Joe");
    public static final Restaurant tuna = new Restaurant(100009, "Tuna");
    public static final Restaurant mario = new Restaurant(100010, "Mario");
    public static final Restaurant miso = new Restaurant(100011, "Miso");
    public static final Restaurant coffee = new Restaurant(100012, "Coffee-Cafe");

    public static final List<Restaurant> restaurants = List.of(joe, tuna, mario, miso, coffee);

    public static Restaurant getUpdated(){
        Restaurant updated = new Restaurant(joe);
        updated.setName("Updated");
        return updated;
    }

    public static Restaurant getNew(){
        return new Restaurant(null, "New");
    }
}
