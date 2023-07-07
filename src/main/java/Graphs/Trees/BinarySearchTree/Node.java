package Graphs.Trees.BinarySearchTree;

public class Node<T> {

    public Node<T> father;
    public Node<T> left;
    public Node<T> right;
    public T value;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}