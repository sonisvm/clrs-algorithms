package graphs;

import java.util.Arrays;

public class DFS {
    private static int time = 0;
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

        dfs(adjList, 10);
    }
    public static void dfs(AdjList adjList, int n) {
        boolean[] visited = new boolean[n];
        int[] start = new int[n];//start timestamp
        int[] finish = new int[n];//finish timestamp
        int[] parent = new int[n];
        Arrays.fill(parent, Integer.MAX_VALUE);

        for (int i=0; i<n; i++) {
            if (!visited[i]){
                dfsHelper(adjList, i, visited, start, finish, parent);
            }
        }

        System.out.println("Discovery times");
        for (int i=0; i<n ; i++) {
            System.out.println("Vertex: "+i+" Start: " + start[i] + " Finish: " + finish[i]);
        }
    }
    public static void dfsHelper(AdjList adjList, int node, boolean[] visited, int[] start, int[] finish,
                                 int[] parent) {
        visited[node] = true;
        start[node] = time;
        time++;
        for(AdjListEntry entry : adjList.getEdges(node)) {
            if (!visited[entry.getNode()]) {
                parent[entry.getNode()] = node;
                dfsHelper(adjList, entry.getNode(), visited, start, finish, parent);
            }
        }
        finish[node] = time;
        time++;
    }
}
