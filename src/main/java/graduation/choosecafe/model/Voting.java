package graduation.choosecafe.model;

import java.util.List;
import java.util.Map;

public class Voting {
    private Integer id;
    private Lunch result;
    private List<Lunch> variants;
    private Map<User,Lunch> votingData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lunch getResult() {
        return result;
    }

    public void setResult(Lunch result) {
        this.result = result;
    }

    public List<Lunch> getVariants() {
        return variants;
    }

    public void setVariants(List<Lunch> variants) {
        this.variants = variants;
    }

    public Map<User, Lunch> getVotingData() {
        return votingData;
    }

    public void setVotingData(Map<User, Lunch> votingData) {
        this.votingData = votingData;
    }
}
