package graphs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {
    public static void main(String[] args) {
        int[][] graph = { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        System.out.println(MSTcost(graph)==16);
    }
    public static int MSTcost(int[][] graph) {
        List<Edge> edges = new ArrayList<>();
        for (int i=0; i<graph.length; i++) {
            for (int j=0;j<=i; j++) {
                if (graph[i][j]!=0){
                    edges.add(new Edge(i, j, graph[i][j]));
                }

            }
        }
        //sort the edges according to weight. O(ElogE)
        Collections.sort(edges, (o1, o2) -> o1.getWeight() - o2.getWeight());

        int numEdges = 0, index=0, totalCost=0;
        DisjointSet disjointSet = new DisjointSet(graph.length);
        List<Edge> mst = new ArrayList<>();

        //O(ElogV)
        while(numEdges < graph.length-1) {
            Edge e = edges.get(index);
            if (disjointSet.find(e.getSrc())!=disjointSet.find(e.getDest())) {
                mst.add(e);
                totalCost += e.getWeight();
                disjointSet.union(e.getSrc(), e.getDest());
                numEdges++;
            }
            index++;
        }

        return totalCost;
    }
}
