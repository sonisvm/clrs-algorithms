package graphs;

public class Subset {
    private int rank;
    private int parent;

    public Subset() {}

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public int getParent() {
        return parent;
    }

    public void incrementRank() {
        this.rank++;
    }
}
