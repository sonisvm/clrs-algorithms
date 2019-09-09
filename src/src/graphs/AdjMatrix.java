package graphs;

public class AdjMatrix {
    private int[][] adjMatrix;

    public AdjMatrix(int n) {
        adjMatrix = new int[n][n];
    }

    public void addEdge(int u, int v, boolean directed) {
        this.addEdge(u, v, 1, directed);
    }

    public void addEdge(int u, int v, int w, boolean directed) {
        adjMatrix[u][v] = w;

        if (!directed) {
            adjMatrix[v][u] = w;
        }
    }

    public int[] getEdges(int u) {
        return this.adjMatrix[u];
    }
}
