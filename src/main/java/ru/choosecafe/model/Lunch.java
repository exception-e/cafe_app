package ru.choosecafe.model;

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

    @Column(name = "price")
    @NotNull
    private Integer price;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    @Column(name = "date", nullable = false)
    @NotNull
    @DateTimeFormat
    private LocalDate date;

    public Lunch() {
    }

    public Lunch(String name, Integer price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Lunch{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
