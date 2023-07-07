package Graphs.Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> implements IBST<T> {

    private Node<T> node;

    @Override
    public T minimum() {

        Node<T> n = node;

        while(n.left != null){
            n = n.left;
        }
        return  n.value;
    }

    @Override
    public boolean contains(T x) {

        Node<T> n = node;

        while(n != null && n.value != x){

            if(n.value.compareTo(x) > 0){
                n = n.left;
            }
            else {
                n = n.right;
            }
        }

        return n == x ? true : false;
    }

    @Override
    public void add(T x) {
        node = add(x, node);
    }

    private Node<T> add(T x, Node<T> n){

        if(n != null){
            int cmp = n.value.compareTo(x);
            if(cmp == 0){
                return n;
            }
            if(cmp > 0){
                n.left = add(x, n.left);
                n.left.father = n;
            }
            else{
                n.right = add(x, n.right);
                n.right.father = n;
            }
            return n;
        }else{
            return new Node<>(x);
        }
    }

    @Override
    public T delete(T x) {
        Node<T> n = node;

        if(contains(x)){

        }
        else{
            return null;
        }

        return null;
    }

    private List<String> print(Node<T> n) {
        List<String> s = new ArrayList<String>();
        s.add("value = " + n.value);
        if (n.left != null) {
            List<String> tmp = print(n.left);
            tmp.set(0, "--L:" + tmp.get(0));
            for (int i = 1; i < tmp.size(); i++) {
                tmp.set(i, "---" + tmp.get(i));
            }
            s.addAll(tmp);
        }
        if (n.right != null) {
            List<String> tmp = print(n.right);
            tmp.set(0, "--P:" + tmp.get(0));
            for (int i = 1; i < tmp.size(); i++) {
                tmp.set(i,"---" + tmp.get(i));
            }
            s.addAll(tmp);
        }
        return s;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        List<String> ss = print(node);
        ss.stream().forEach((t) -> {
            s.append(t + "\n");
        });
        return s.toString();
    }

    public static void main(String[] args) {
        IBST<Integer> bst = new BST<>();
        int[] tab = { 7, 15, 5, 1, 9, 10, 2, 6, 20 };
        for(int i : tab)
        {
            bst.add(i);
        }
        System.out.println(bst.toString());

        System.out.println("Searching");
        System.out.println("-------Searching for value 8, not found-------");
        System.out.println(bst.contains(8));
        System.out.println("-------Searching for value 6, present in the tree-------");
        System.out.println(bst.contains(6));
        System.out.println("-------Minimum value-------");
        System.out.println(bst.minimum());
        System.out.println("-------Successor-------");
        int toDelete = 7;
        System.out.println("-------Deleting " + toDelete + "-------");
        System.out.println("Deleted: " + bst.delete(toDelete));
        System.out.println("-------Tree after deletion-------");
        System.out.println(bst);
        toDelete = 9;
        System.out.println("-------Deleting " + toDelete + "-------");
        System.out.println("Deleted: " + bst.delete(toDelete));
        System.out.println("-------Tree after deletion-------");
        System.out.println(bst);
    }
}
