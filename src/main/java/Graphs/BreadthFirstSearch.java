package Graphs;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Data
class VertexBFS<T> {
    private final T data;
    private boolean visited;
    @ToString.Exclude
    private List<VertexBFS<T>> neighbors = new LinkedList<>();
}

public class BreadthFirstSearch<T> {
    private final VertexBFS<T> startVertex;

    public BreadthFirstSearch(VertexBFS<T> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {

        Queue<VertexBFS<T>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            VertexBFS<T> current = queue.poll();

            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getNeighbors());
            }
        }
    }
}

class BFSrunner {
    public static void main(String[] args) {

        VertexBFS<Integer> v0 = new VertexBFS<>(0);
        VertexBFS<Integer> v1 = new VertexBFS<>(1);
        VertexBFS<Integer> v2 = new VertexBFS<>(2);
        VertexBFS<Integer> v3 = new VertexBFS<>(3);
        VertexBFS<Integer> v4 = new VertexBFS<>(4);
        VertexBFS<Integer> v5 = new VertexBFS<>(5);
        VertexBFS<Integer> v6 = new VertexBFS<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(List.of(v0));

        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v0);
        bfs.traverse();
    }
}