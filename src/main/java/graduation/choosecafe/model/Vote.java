package graduation.choosecafe.model;

import javax.persistence.*;

@Entity
@Table(name="voting_process", uniqueConstraints = @UniqueConstraint(columnNames = {"voting_id", "user_id"}))
public class Vote extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name="voting_id")
    private Voting voting;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="lunch_id")
    private Lunch lunch;

    public Vote(Voting voting, User user, Lunch lunch) {
        this.voting = voting;
        this.user = user;
        this.lunch = lunch;
    }

    public Vote() {
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }
}
