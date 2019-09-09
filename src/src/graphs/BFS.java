package graphs;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BFS {
    public static void main(String[] args) {
        AdjList adjList = new AdjList();
        adjList.addEdge(0, 8, false);
        adjList.addEdge(1, 3, false);
        adjList.addEdge(1, 7, false);
        adjList.addEdge(1, 9, false);
        adjList.addEdge(1, 2, false);
        adjList.addEdge(2, 8, false);
        adjList.addEdge(2, 4, false);
        adjList.addEdge(3, 4, false);
        adjList.addEdge(3, 5, false);
        adjList.addEdge(5, 6, false);
        adjList.addEdge(6, 7, false);
        adjList.addEdge(8, 9, false);
        adjList.addEdge(0, 8, false);

        bfs(adjList, 0, 10);


    }

    public static void bfs(AdjList adjList, int src, int n) {
        int[] parent = new int[n];
        Arrays.fill(parent, Integer.MAX_VALUE);
        // color: 0 for unvisited, 1 for queued, 2 for completed
        int[] color = new int[n]; // this color is important to find the shortest path. If we are only keeping a
        // visited array, the path we get may not be shortest path from src to a node.
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        dist[src] = 0;
        parent[src] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            color[node] = 2;
            for (AdjListEntry entry : adjList.getEdges(node)){
                int next = entry.getNode();
                if (color[next]==0) {
                    dist[next] = dist[node] + 1;
                    parent[next] = node;
                    color[next] = 1;
                    queue.addLast(next);
                }
            }
        }

        System.out.println("Distances from source node");
        for (int i=0; i<dist.length;i++) {
            System.out.println("Vertex: " + i +" Dist: " + dist[i]);
        }

        printPath(parent, 0, 6);
    }
    public static void printPath(int[] parent, int s, int v) {
        if (s == v) {
            System.out.print(s + "->");
        } else if (parent[v] == Integer.MAX_VALUE) {
            System.out.println("No path exists");
            return;
        } else {
            printPath(parent, s, parent[v]);
            System.out.print(v + "->");
        }
    }
}
