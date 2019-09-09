package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StronglyConnectedComponents {
    public static void main(String[] args) {
        AdjList adjList = new AdjList();
        adjList.addEdge(0,1,true);
        adjList.addEdge(1,2,true);
        adjList.addEdge(2,0,true);
        adjList.addEdge(1,3,true);
        adjList.addEdge(2,3,true);
        adjList.addEdge(1,5,true);
        adjList.addEdge(3,4,true);
        adjList.addEdge(4,3,true);
        adjList.addEdge(5,4,true);
        adjList.addEdge(5,6,true);
        adjList.addEdge(6,5,true);
        adjList.addEdge(6,7,true);
        adjList.addEdge(7,7,true);
        adjList.addEdge(4,7,true);

        int[] cc = SCC(adjList, 8);
        for (int i=0; i<cc.length; i++) {
            System.out.println("Vertex: " + i +" SCC: "+ cc[i]);
        }
    }
    public static int[] SCC(AdjList adjList, int n) {
        int[] cc = new int[n];
        boolean[] visited = new boolean[n];
        List<Vertex> vertices = new ArrayList<>();

        int time = 0;
        for (int i=0; i< n ; i++) {
            if (!visited[i]) {
                time = dfs(adjList, i, time, visited, vertices);
            }
        }

        Collections.sort(vertices, (v1, v2)-> v2.getFinishTime() - v1.getFinishTime());

        AdjList reversed = reverse(adjList, n);

        Arrays.fill(visited, false);
        int ccNum = 0;
        for (Vertex i : vertices) {
            if(!visited[i.getNode()]) {
                dfsCC(reversed, i.getNode(), visited, ccNum, cc);
                ccNum++;
            }
        }
        return cc;
    }
    public static int dfs(AdjList adjList, int node, int time, boolean[] visited, List<Vertex> vertices) {
        visited[node] = true;
        time++;
        for (AdjListEntry entry : adjList.getEdges(node)) {
            if (!visited[entry.getNode()]) {
                time = dfs(adjList, entry.getNode(), time, visited, vertices);
            }
        }
        vertices.add(new Vertex(node, time));
        return time+1;
    }
    public static void dfsCC(AdjList adjList, int node, boolean[] visited, int ccNum, int[] cc) {
        visited[node] = true;
        cc[node] = ccNum;
        for (AdjListEntry entry : adjList.getEdges(node)) {
            if (!visited[entry.getNode()]) {
                dfsCC(adjList, entry.getNode(), visited, ccNum, cc);
            }
        }
    }
    public static AdjList reverse(AdjList adjList, int n){
        AdjList newAdjList = new AdjList();

        //O(V+E)
        for (int i=0; i<n; i++) {
            for (AdjListEntry entry : adjList.getEdges(i)) {
                newAdjList.addEdge(entry.getNode(), i, true);
            }
        }
        return newAdjList;
    }
}
