package ru.cafe_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="lunch")
public class Lunch extends AbstractBaseEntity{

    @Column(name = "name")
    @Size(max = 100)
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "price_cents")
    @NotNull
    private Integer price;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Restaurant restaurant;

    @Column(name = "date", nullable = false, insertable = false)
    @NotNull
    @DateTimeFormat
    private LocalDate date;

    public Lunch() {
    }

    public Lunch(Integer id, String name, Integer price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public Lunch(Integer id, String name, Integer price, int restaurantId) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public Lunch(Lunch lunch){
        super(lunch.id);
        this.name = lunch.name;
        this.price = lunch.price;
        this.date = lunch.date;
        this.restaurant=lunch.restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
