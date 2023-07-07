package Collections.Lists.LinkedList;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {

    Element<E> element;

    public LinkedListIterator(Element<E> element) {
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
