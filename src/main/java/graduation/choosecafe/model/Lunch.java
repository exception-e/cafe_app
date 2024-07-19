package graduation.choosecafe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Set;

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
    @JoinColumn(name = "id")
    Restaurant restaurant;

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
