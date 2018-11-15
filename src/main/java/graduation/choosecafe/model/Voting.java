package graduation.choosecafe.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="votings")
public class Voting extends AbstractBaseEntity{

    @Column(name = "voting_date")
    //@NotNull доделать со спрингом
    private LocalDate date;


    //private Lunch result;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voting")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @BatchSize(size = 200)
    private Set<Lunch> variants;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voting")
    @BatchSize(size = 200)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinTable(name = "voting_process", joinColumns = @JoinColumn(name = "voting_id"))
    //@CollectionTable(name = "voting_process", joinColumns = @JoinColumn(name = "voting_id"))
    //@MapKeyJoinColumn(name = "user_id")
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


}
