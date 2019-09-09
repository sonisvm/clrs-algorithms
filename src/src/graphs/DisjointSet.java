package graphs;

public class DisjointSet {
    private Subset[] subsets;

    public DisjointSet(int n) {
        subsets = new Subset[n];
        for (int i=0; i< n; i++) {
            subsets[i] = new Subset();
            subsets[i].setParent(i);
            subsets[i].setRank(0);
        }
    }

    public int find(int x) {
        if (subsets[x].getParent() == x) {
            return x;
        }
        int p = find(subsets[x].getParent());
        subsets[x].setParent(p);
        return p;
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (subsets[xParent].getRank() == subsets[yParent].getRank()) {
            subsets[xParent].setParent(yParent);
            subsets[yParent].incrementRank();
        } else if (subsets[xParent].getRank() < subsets[yParent].getRank()) {
            subsets[xParent].setParent(yParent);
        } else {
            subsets[yParent].setParent(xParent);
        }
    }
}
