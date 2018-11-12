package graduation.choosecafe.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="voting_variants")
public class votingVariant {

    @PrimaryKeyJoinColumn(name = "voting_id")
    Integer votingId;
    @PrimaryKeyJoinColumn
    Integer lunchId;
}
