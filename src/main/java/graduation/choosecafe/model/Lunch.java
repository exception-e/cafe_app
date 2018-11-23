package graduation.choosecafe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="lunches")
public class Lunch extends AbstractBaseEntity{

    @Column(name = "name")
    @Size(max = 100)
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "menu")
    @Size(max = 250)
    private String menu;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voting_id")
    @NotNull
    private Voting voting;

    public Lunch() {
    }

    public Lunch(String name, String menu, Voting voting) {
        this.name = name;
        this.menu = menu;
        this.voting = voting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "name='" + name + '\'' +
                ", menu='" + menu + '\'' +
                ", voting=" + voting +
                ", id=" + id +
                '}';
    }
}
