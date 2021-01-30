import java.util.*;

public class Graph {

    Map<Integer, Vertex> vertices;
    List<Edge> edges;

    public Graph() {
        vertices = new HashMap<>();
        edges = new ArrayList<>();
    } 

    public void addNode(int id) {
       if (vertices.keySet().contains(id)) {
           throw new IllegalArgumentException("A vertex with given is already exists in the graph");
       }
       vertices.put(id, new Vertex(id));
    }

    public void addNodes(Set<Integer> ids) {
        for (int id : ids) {
            addNode(id);
        }
    }
    

    public void addEdge(int from, int to, int weight) {
        if (!vertices.keySet().contains(from) || !vertices.keySet().contains(to)) {
            throw new IllegalArgumentException("One of the two specified nodes couldn't be found in the graph");
        }
        Edge edge = new Edge(from, to, weight);
        vertices.get(from).outEdges.add(edge);
        edges.add(edge);
    }

    public void addEdge(Edge edge) {
        if (!vertices.keySet().contains(edge.from) || !vertices.keySet().contains(edge.to)) {
            throw new IllegalArgumentException("One of the two specified nodes couldn't be found in the graph");
        }
        vertices.get(edge.from).outEdges.add(edge);
        edges.add(edge);
    }

    public void addEdges(Set<Edge> edges) {
        for (Edge edge : edges) {
            addEdge(edge);
        }
    }

    public String toString() {
        String output = "";
        for (Vertex vertex : vertices.values()) {
            output += "Vertex " + vertex.id + "\n" + "    " + "Edges to: ";
            for (Edge edge : vertex.outEdges) {
                output += edge.to + " (weight: " + edge.weight + ")" + ", ";
            }
            if (!vertex.outEdges.isEmpty()) {
                output = output.substring(0, output.length() - 2);
            }
            output += "\n";
        }
        return output;
    }
}