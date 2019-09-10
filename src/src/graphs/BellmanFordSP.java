package graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordSP {
    private static int[] dist;
    private static int[] pred;
    public static void main(String[] args) {
        AdjList adjList = new AdjList();
        adjList.addEdge(0, 1, -1, true);
        adjList.addEdge(0, 2, 4, true);
        adjList.addEdge(1, 2, 3, true);
        adjList.addEdge(1, 4, 2, true);
        adjList.addEdge(3, 2, 5, true);
        adjList.addEdge(3, 1, 1, true);
        adjList.addEdge(1, 3, 2, true);
        adjList.addEdge(4, 3, -3, true);

        shortestPath(adjList, 5, 0);
        for (int i=0; i<dist.length; i++) {
            System.out.println("Vertex: " + i + " Dist: " + dist[i] + " Pred: " + pred[i]);
        }
    }
    public static boolean shortestPath(AdjList adjList, int n, int src) {
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pred = new int[n];
        Arrays.fill(pred, Integer.MAX_VALUE);

        dist[src] = 0;
        for (int i=0; i<n-1; i++) {
            for (Map.Entry<Integer, List<AdjListEntry>> entry : adjList.getAdjList().entrySet()) {
                int u = entry.getKey();
                for (AdjListEntry v : entry.getValue()) {
                    //Having this != MAX check is important.
                    if (dist[u] != Integer.MAX_VALUE && dist[v.getNode()] > dist[u] + v.getWeight()) {
                        dist[v.getNode()] = dist[u] + v.getWeight();
                        pred[v.getNode()] = u;
                    }
                }
            }
        }

        //checking if there is a negative cycle
        for (Map.Entry<Integer, List<AdjListEntry>> entry : adjList.getAdjList().entrySet()) {
            int u = entry.getKey();
            for (AdjListEntry v : entry.getValue()) {
                if(dist[v.getNode()] > dist[u] + v.getWeight()) {
                    return false;
                }
            }
        }
        return true;
    }
}
