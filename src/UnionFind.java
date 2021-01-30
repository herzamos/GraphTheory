import java.util.*;

public class UnionFind {

    private Map<Integer, Vertex> vertices;
    private Map<Integer, Integer> ids;
    private Map<Integer, Integer> size;

    UnionFind(Graph graph) {
        this.vertices = graph.vertices;
        ids = new HashMap<>();
        size = new HashMap<>();
        for (Vertex vertex : vertices.values()) {
            this.ids.put(vertex.id, vertex.id);
            this.size.put(vertex.id, 1);
        }
    }

    private int find(Vertex x) {
        while (x.id != ids.get(x.id)) {
            ids.put(x.id, ids.get(ids.get(x.id)));
            x = vertices.get(ids.get(x.id));
        }
        return ids.get(x.id);
    }

    public boolean same(Vertex x, Vertex y) {
        return find(x) == find(y);
    }

    public void union(Vertex x, Vertex y) {
        int i = find(x);
        int j = find(y);
        if (size.get(i) < size.get(j)) {
            ids.put(i, j);
            size.put(j, size.get(j) + size.get(i));
        }
        else {
            ids.put(j, i);
            size.put(i, size.get(i) + size.get(j));
        }
    }

    
}
