package graphs;

import java.util.Arrays;
import java.util.List;

public class DAGShortestPath {
    private static int[] dist;
    private static int[] pred;
    public static void main(String[] args) {
        AdjList adjList = new AdjList();
        adjList.addEdge(0,1,5, true);
        adjList.addEdge(0,2,3, true);
        adjList.addEdge(1,2,2, true);
        adjList.addEdge(1,3,6, true);
        adjList.addEdge(2,3,7, true);
        adjList.addEdge(2,4,4, true);
        adjList.addEdge(2,5,2, true);
        adjList.addEdge(3,5,1, true);
        adjList.addEdge(3,4,-1, true);
        adjList.addEdge(4,5,-2, true);

        shortestPath(adjList, 6, 1);

        for (int i=0; i<dist.length; i++) {
            System.out.println("Vertex: " + i + " Dist: " + dist[i] + " Pred: " + pred[i]);
        }
    }
    public static void shortestPath(AdjList adjList, int n, int src) {
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pred = new int[n];
        Arrays.fill(pred, Integer.MAX_VALUE);

        List<Integer> sorted = TopologicalSort.topologicalSortUsingDFS(adjList, n);

        for (int i : sorted) {
            for (AdjListEntry entry : adjList.getEdges(i)) {
                if (dist[i] != Integer.MAX_VALUE && dist[entry.getNode()] > dist[i] + entry.getWeight()) {
                    dist[entry.getNode()] = dist[i] + entry.getWeight();
                    pred[entry.getNode()] = i;
                }
            }
        }
    }
}
