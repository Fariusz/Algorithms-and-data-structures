package Graphs;

import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
class VertexDFS<T> {
    private final T data;
    private boolean visited;
    @ToString.Exclude
    private List<VertexDFS<T>> neighbors = new ArrayList<>();
}

public class DeepFirstSearch<T> {

    private final VertexDFS<T> startVertex;

    public DeepFirstSearch(VertexDFS<T> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {

        Deque<VertexDFS> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            VertexDFS<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                Collections.reverse(current.getNeighbors());
                current.getNeighbors().forEach(stack::push);
            }

        }
    }

    public void traverseRecursively(VertexDFS<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbors().forEach(neighbor -> {
            if (!neighbor.isVisited()) {
                traverseRecursively(neighbor);
            }
        });
    }

    public void traverseRecursively2(VertexDFS<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbors().stream()
                .filter(neighbor -> !neighbor.isVisited())
                .forEach(this::traverseRecursively2);
    }
}

class DFSrunner {
    public static void main(String[] args) {

        VertexDFS<Integer> v0 = new VertexDFS<>(0);
        VertexDFS<Integer> v1 = new VertexDFS<>(1);
        VertexDFS<Integer> v2 = new VertexDFS<>(2);
        VertexDFS<Integer> v3 = new VertexDFS<>(3);
        VertexDFS<Integer> v4 = new VertexDFS<>(4);
        VertexDFS<Integer> v5 = new VertexDFS<>(5);
        VertexDFS<Integer> v6 = new VertexDFS<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(List.of(v0));

        DeepFirstSearch<Integer> bfs = new DeepFirstSearch<>(v0);
        bfs.traverse();
    }
}