package ru.choosecafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractBaseEntity {

    String name;

    @Column(name = "name")
    @Size(max = 100)
    @NotBlank
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @BatchSize(size = 200)
    @JsonIgnore
    Set<Lunch> lunches;

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lunch> getLunches() {
        return lunches;
    }

    public void setLunches(Set<Lunch> lunches) {
        this.lunches = lunches;
    }

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Restaurant() {
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}