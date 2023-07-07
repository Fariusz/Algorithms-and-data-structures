package Collections.Lists;

public interface List<E> {

    void add(E e);

    E delete(int i);

    void put(int i, E e);

    int find(E e);

    E get(int i);

    int length();
}
