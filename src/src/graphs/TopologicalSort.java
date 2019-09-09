package graphs;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        AdjList adjList = new AdjList();
        adjList.addEdge(0, 1, true);
        adjList.addEdge(1, 2, true);
        adjList.addEdge(1, 3, true);
        adjList.addEdge(3, 4, true);
        adjList.addEdge(2, 4, true);
        adjList.addEdge(4, 5, true);
        adjList.addEdge(4, 6, true);
        adjList.addEdge(5, 7, true);
        adjList.addEdge(6, 7, true);

        LinkedList<Integer> sorted = topologicalSortUsingDFS(adjList, 8);
        for (int n : sorted) {
            System.out.print(n + "->");
        }

        System.out.println();
        List<Integer> result = topologicalSortIterative(adjList, 8);
        for (int n : result) {
            System.out.print(n + "->");
        }
    }
    public static LinkedList<Integer> topologicalSortUsingDFS(AdjList adjList, int n) {
        boolean[] visited = new boolean[n];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(adjList, i, list, visited);
            }
        }
        return list;
    }
    public static void dfs(AdjList adjList, int node, LinkedList<Integer> list, boolean[] visited) {
        visited[node] = true;
        for (AdjListEntry entry : adjList.getEdges(node)) {
            if (!visited[entry.getNode()]) {
                dfs(adjList, entry.getNode(), list, visited);
            }
        }
        list.addFirst(node);
    }

    //Kahn's algorithm
    public static List<Integer> topologicalSortIterative(AdjList adjList, int n) {
        int[] indegrees = new int[n];
        //O(E)
        for (int i=0; i<n; i++) {
            for (AdjListEntry entry : adjList.getEdges(i)) {
                indegrees[entry.getNode()]++;
            }
        }
        Deque<Integer> sources = new ArrayDeque<>();
        //O(V)
        for (int i=0; i<n; i++) {
            if (indegrees[i] == 0) {
                sources.addLast(i);
            }
        }

        //O(E)
        List<Integer> result = new ArrayList<>();
        while (!sources.isEmpty()) {
            int node = sources.pollFirst();
            result.add(node);
            for (AdjListEntry entry : adjList.getEdges(node)) {
                indegrees[entry.getNode()]--;
                if (indegrees[entry.getNode()] == 0) {
                    sources.addLast(entry.getNode());
                }
            }
        }
        return result;
    }
}
