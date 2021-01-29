import java.util.*;

public class DFS {

    Graph graph;
    List<Vertex> visited;
    Map<Integer, Vertex> preOrder;
    Map<Integer, Vertex> postOrder;
    int i = 0;

    DFS(Graph graph, Vertex startingNode) {
        this.graph = graph;
        visited = new ArrayList<>();
        preOrder = new TreeMap<>();
        postOrder = new TreeMap<>();

        for (Vertex vertex : graph.vertices.values()) {
            if(!visited.contains(vertex)) {
                DFSricorsive(vertex);
            }
        }
    }

    public void DFSricorsive(Vertex vertex) {
        preOrder.put(i, vertex);
        i++;
        visited.add(vertex);
        for (Edge edge : vertex.outEdges) {
            if (!visited.contains(graph.vertices.get(edge.to))) {
                DFSricorsive(graph.vertices.get(edge.to));
            }
        }
        postOrder.put(i, vertex);
        i++;
    }

    public String toString() {
        String output = "";
        output += "Pre Order: ";
        for (Vertex vertex : preOrder.values()) {
            output += vertex.id + ", ";
        }
        output = output.substring(0, output.length()-2);
        output += "\nPost Order: ";
        for (Vertex vertex : postOrder.values()) {
            output += vertex.id + ", ";
        }
        output = output.substring(0, output.length()-2);
        return output;
    }

}
