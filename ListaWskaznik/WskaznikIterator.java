package polsl.pl.ListaWskaznik;

import java.util.Iterator;

public class WskaznikIterator<E> implements Iterator<E> {

    Element<E> element;

    public WskaznikIterator(Element<E> element) {
        this.element = new Element<>(null, element);
    }

    @Override
    public boolean hasNext() {
        return (element.next != null);
    }

    @Override
    public E next() {
        element = element.next;
        return element.object;
    }
}
