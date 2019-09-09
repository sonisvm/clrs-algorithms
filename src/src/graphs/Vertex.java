package graphs;

public class Vertex {
    private int node;
    private int finishTime;

    public Vertex(int node) {
        this.node = node;
    }

    public Vertex(int node, int time) {
        this.node = node;
        finishTime = time;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getNode() {
        return node;
    }
}
