package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DjikstraSP {
    private static int[] dist;
    private static int[] pred;
    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix(5);
        adjMatrix.addEdge(0,1,10, true);
        adjMatrix.addEdge(0,3,5, true);
        adjMatrix.addEdge(1,2,1, true);
        adjMatrix.addEdge(1,3,2, true);
        adjMatrix.addEdge(3,1,3, true);
        adjMatrix.addEdge(3,2,9, true);
        adjMatrix.addEdge(3,4,2, true);
        adjMatrix.addEdge(4,2,6, true);
        adjMatrix.addEdge(2,4,4, true);

        shortestPath(adjMatrix, 0);

        for (int i=0; i<dist.length; i++) {
            System.out.println("Vertex: " + i + " Dist: " + dist[i] + " Pred: " + pred[i]);
        }
    }
    public static void shortestPath(AdjMatrix graph, int src) {
        int n = graph.getSize();
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pred = new int[n];
        Arrays.fill(pred, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1]-b[1]);
        queue.add(new int[]{src, 0});
        dist[src]=0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (visited[curr[0]]) {
                continue;
            }
            visited[curr[0]] = true;
            int node = curr[0];
            int[] edges = graph.getEdges(node);
            for (int i = 0; i< edges.length; i++){
                if (!visited[i] && edges[i] != 0 && dist[i] > dist[node] + edges[i]){
                    dist[i] = dist[node] + edges[i];
                    pred[i] = node;
                    queue.add(new int[]{i, dist[i]});
                }
            }
        }
    }
}
