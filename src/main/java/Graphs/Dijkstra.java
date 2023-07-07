package Graphs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra {

    public static void printPaths(List<Node> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getName)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance())));
        });
    }

    public void calculateShortestPath(Node source) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));
        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry ->
                            !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
    }

    private void evaluateDistanceAndPath(Node adjacentNode, Integer edgeWeight, Node sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(
                    Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList()
            );
        }
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    static
    class Node implements Comparable<Node> {

        private final String name;
        private Integer distance = Integer.MAX_VALUE;
        private List<Node> shortestPath = new LinkedList<>();
        private Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addAdjacentNode(Node node, int weight) {
            adjacentNodes.put(node, weight);
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.getDistance());
        }
    }

}

class runner {
    public static void main(String[] args) {
        Dijkstra.Node nodeA = new Dijkstra.Node("A");
        Dijkstra.Node nodeB = new Dijkstra.Node("B");
        Dijkstra.Node nodeC = new Dijkstra.Node("C");
        Dijkstra.Node nodeD = new Dijkstra.Node("D");
        Dijkstra.Node nodeE = new Dijkstra.Node("E");
        Dijkstra.Node nodeF = new Dijkstra.Node("F");


        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);

        new Dijkstra().calculateShortestPath(nodeA);
        Dijkstra.printPaths(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));
    }
}
