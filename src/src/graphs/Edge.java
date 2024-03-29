package graphs;

public class Edge {
    private int src;
    private int dest;
    private int weight;

    public Edge(int src, int dest, int weight) {
        this.dest = dest;
        this.src = src;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }
}
