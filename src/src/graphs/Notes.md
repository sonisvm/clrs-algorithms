### Graph Representation

* If G is a directed graph, sum of length of all the adjacency lists = |E|. If G is an undirected graph, sum of length
of all the adjacency lists = 2|E|.

* For both directed and undirected graphs, the adjacency-list representation has the desirable property that the amount 
of memory it requires = O(V+E).

### Breadth-First Search

* Prim's algorithm and Dijkstra's algorithm use similar idea.

* BFS computes the **shortest distance** from the source node to every other reachable node, in **an undirected unweighted** 
**graph**. It can find shortest path in **cyclic graphs**, but we need to keep track of queued nodes in addition to 
visited nodes.

* For any vertex 􏰁v reachable from s, the simple path in the breadth-first tree from s to v􏰁 corresponds to a 
“shortest path” from s to v􏰁 in G, that is, a path containing the smallest number of edges.

* The algorithm discovers all vertices at distance k from s before discovering any vertices at distance k + 1.

* The shortest path from node s to v can be obtaining by traversing the parent array from node v back to s.

* Total running time = O(V + E).

### Depth-First Search

* In contrast to BFS, DFS algorithm runs on multiple source nodes. Hence, the result is not a DFS
tree but a DFS forest.

* Total running time = O(V + E).

* Following properties hold in a DFS tree
    - [u.start, u.finish] and [v.start, v.finish] are completely disjoint and neither u nor v are descendants of each
     other in the tree.
    - v.start < u.start < u.finish < v.finish implies that u is a descendant of v.

* Classification of edges
    - **Tree edges** are the edges of the DFS tree. Edge (u, v) is a tree edge if v was discovered using this edge.
    - If u is a descendant of v in the DFS tree and there is an edge (u,v) in the graph, this edge is called a **back** 
    **edge**.
    - **Forward edges** are non tree edges (u,v) that connect ancestor u to descendant v.
    - **Cross edges** are all other edges, i.e. edges between two vertices in same DFS tree which are not in an 
    ancestor-descenant relationship, as well as edges between different DFS trees. 

* DFS of an undirected graph only yields tree edges and forward edges.






