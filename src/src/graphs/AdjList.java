package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AdjListEntry {
    private int node;
    private int weight;
    public AdjListEntry(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}

public class AdjList {
    private Map<Integer, List<AdjListEntry>> adjList;

    public AdjList() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, boolean directed) {
        this.addEdge(u, v, 0, directed);
    }

    public void addEdge(int u, int v, int w, boolean directed) {
        List<AdjListEntry> edges = adjList.getOrDefault(u, new ArrayList<>());
        edges.add(new AdjListEntry(v, w));
        adjList.put(u, edges);

        if (!directed) {
            edges = adjList.getOrDefault(v, new ArrayList<>());
            edges.add(new AdjListEntry(u, w));
            adjList.put(v, edges);
        }
    }

    public List<AdjListEntry> getEdges(int u) {
        return adjList.getOrDefault(u, new ArrayList<>());
    }
}
