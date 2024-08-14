package ru.choosecafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="vote", uniqueConstraints = @UniqueConstraint(columnNames = {"date", "user_id"}))
public class Vote extends AbstractBaseEntity {

    @Column(name = "date")
    //@NotNull
    @DateTimeFormat()
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Restaurant restaurant;

    public Vote(LocalDate date, User user, Restaurant restaurant) {
        this.date = date;
        this.user = user;
        this.restaurant = restaurant;
    }

    public Vote() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
