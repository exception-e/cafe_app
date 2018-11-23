package graduation.choosecafe.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="votings")
public class Voting extends AbstractBaseEntity{

    @Column(name = "voting_date")
    //@NotNull
    @DateTimeFormat()
    private LocalDate date;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voting")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @BatchSize(size = 200)
    private Set<Lunch> variants;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voting")
    @BatchSize(size = 200)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Vote> votes;

    public Voting() {
    }

    public Set<Vote> getVotes()
    {
        return votes;
    }

    public Voting(LocalDate date) {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Lunch> getVariants() {
        return variants;
    }

    public void setVariants(Set<Lunch> variants) {
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "date=" + date +
                ", variants=" + variants +
                ", votes=" + votes +
                ", id=" + id +
                '}';
    }
}
