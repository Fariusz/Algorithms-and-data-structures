package polsl.pl.DrzewaPrzeszukiwanBinarnych;

public class Node<T> {

    public Node<T> ojciec;
    public Node<T> lewy;
    public Node<T> prawy;
    public T wartosc;

    public Node(T wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public String toString() {
        return "Node{" +
                "wartosc=" + wartosc +
                '}';
    }
}
