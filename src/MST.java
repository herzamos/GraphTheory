import java.util.*;

public class MST {
    
    Graph graph;

    /**
     * Initalise a new MST on the graph given as parameter.
     * 
     * @param graph
     */
    MST(Graph graph) {
        this.graph = graph;
    }

    /**
     * Execute Kruskal's algorithm on the graph and return it as a Graph object.
     * 
     * @return A graph, which is a MST
     */
    public Graph Kruskal() {
        Graph KruskalMST = new Graph();
        UnionFind uFind = new UnionFind(graph);
        ArrayList<Edge> edges = new ArrayList<>(graph.edges);
        Collections.sort(edges);
        while (KruskalMST.edges.size() < graph.vertices.size() - 1) {
            Edge edge = edges.get(0);
            if (!uFind.same(graph.vertices.get(edge.from), graph.vertices.get(edge.to))) {
                if (!KruskalMST.vertices.containsKey(edge.from)) {
                    KruskalMST.addNode(edge.from);
                }
                if (!KruskalMST.vertices.containsKey(edge.to)) {
                    KruskalMST.addNode(edge.to);
                }
                KruskalMST.addEdge(edge);
                uFind.union(graph.vertices.get(edge.from), graph.vertices.get(edge.to));
            }
            edges.remove(0);
        }

        return KruskalMST;
    }

}
