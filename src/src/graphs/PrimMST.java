package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimMST {
    public static void main(String[] args) {
        int[][] graph = { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        System.out.println(MSTcost(graph)==16);
    }
    public static int MSTcost(int[][] graph) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getKey() == o2.getKey()){
                return 0;
            } else if(o1.getKey() > o2.getKey()) {
                return 1;
            } else {
                return -1;
            }
        });
        //v.key is the minimum weight of any edge connecting v to a vertex in the tree
        //every node that has been extracted from the queue is a vertex in the tree
        int[] key = new int[graph.length];
        //O(V)
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        boolean[] visited = new boolean[graph.length];

        queue.add(new Vertex(0, key[0]));
        //O(ElogV + VlogV)
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (visited[v.getNode()]) { //this would prevent duplicate processing when same node is queued with
                // different keys. Whenever we process a node for the first time, its key would be the least possible.
                continue;
            }
            visited[v.getNode()] = true;
            for (int i=0; i<graph[0].length; i++) {
                if (!visited[i] && graph[v.getNode()][i]!=0) {
                    if (key[i] > graph[v.getNode()][i]) {

                        key[i] = graph[v.getNode()][i];
                        queue.add(new Vertex(i, key[i]));
                    }
                }
            }
        }

        int cost = 0;
        for (int i=0; i<key.length; i++) {
            if (key[i]!=Integer.MAX_VALUE) {
                cost += key[i];
            }
        }
        return cost;
    }
}
