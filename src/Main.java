import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNodes(new HashSet<>(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        graph.addEdges(new HashSet<>(Set.of(new Edge(0, 1, 3), 
                                            new Edge(1, 7, 2),
                                            new Edge(7, 2, 4),
                                            new Edge(1, 2, 5),
                                            new Edge(2, 9, 3),
                                            new Edge(3, 2, 6),
                                            new Edge(9, 3, 4),
                                            new Edge(0, 5, 2),
                                            new Edge(5, 3, 1),
                                            new Edge(3, 6, 2),
                                            new Edge(5, 4, 3),
                                            new Edge(8, 5, 4),
                                            new Edge(8, 4, 2),
                                            new Edge(6, 8, 3),
                                            new Edge(3, 1, 4))));
        System.out.print(graph);
        System.out.println("----------------------------------------------------");
        DFS dfs = new DFS(graph, graph.vertices.get(0));
        System.out.print(dfs);
    }
}
