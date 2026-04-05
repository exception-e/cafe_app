package ru.cafe_app.to;

import java.io.*;

public class VoteTo implements Externalizable {
    Integer restaurantId;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {



    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public VoteTo(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public VoteTo() {
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}


