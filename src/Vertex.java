import java.util.*;

public class Vertex {
    List<Edge> outEdges;
    int id;

    Vertex(int id) {
        outEdges = new ArrayList<>();
        this.id = id;
    }
}
