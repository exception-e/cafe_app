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

    @Column(name = "voting_date", nullable = false)
    @NotNull
    private LocalDate date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Lunch result;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "voting_variants", joinColumns = @JoinColumn(name = "voting_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @BatchSize(size = 200)
    private Set<Lunch> variants;


    @JoinTable(name = "voting_process", joinColumns = @JoinColumn(name = "voting_id"))
    @OneToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @BatchSize(size = 200)
    private Map<User,Lunch> votingProcess;

    public Voting() {
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Lunch getResult() {
        return result;
    }

    public void setResult(Lunch result) {
        this.result = result;
    }

    public Set<Lunch> getVariants() {
        return variants;
    }

    public void setVariants(Set<Lunch> variants) {
        this.variants = variants;
    }

    public Map<User, Lunch> getVotingProcess() {
        return votingProcess;
    }

    public void setVotingProcess(Map<User, Lunch> votingData) {
        this.votingProcess = votingData;
    }
}
