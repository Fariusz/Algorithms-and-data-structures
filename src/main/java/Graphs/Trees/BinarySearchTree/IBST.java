package Graphs.Trees.BinarySearchTree;

public interface IBST<T extends Comparable<T>> {
    T minimum();
    T delete(T x);
    void add(T x);
    boolean contains(T x);
}