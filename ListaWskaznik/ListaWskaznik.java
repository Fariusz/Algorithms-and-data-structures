package polsl.pl.ListaWskaznik;

import polsl.pl.Lista;

import java.util.Iterator;

public class ListaWskaznik<E> implements Lista<E>, Iterable {

    Element<E> firstElement;
    Element<E> lastElement;
    int count;

    public ListaWskaznik() {
        this.firstElement = null;
        this.lastElement = null;
    }

    @Override
    public void dodaj(E e) {
        if (count == 0) {
            this.firstElement = new Element<E>(null, null);
            this.lastElement = this.firstElement;
            lastElement.object = e;
            count++;
        } else {
            lastElement.next = new Element<E>(e);
            lastElement = lastElement.next;
            count++;
        }
    }

    private Element<E> findElement(int elementId) {

        Element<E> element = firstElement;
        for (int i = 0; i < elementId; i++) {
            element = element.next;
        }
        return element;
    }

    @Override
    public E usun(int i) {
        Element<E> removedElement;
        E removedObject;
        if (i == 0) {
            removedElement = firstElement;
            firstElement = removedElement.next;

        } else {
            Element<E> previousElement = findElement(i - 1);
            removedElement = previousElement.next;
            previousElement.next = removedElement.next;

        }
        removedObject = removedElement.object;
        removedElement.next = null;
        removedElement.object = null;
        if (lastElement == removedElement) {
            Element element = firstElement;
            do {
                if (element.next == null) {
                    lastElement = element;
                } else {
                    element = element.next;
                }
            } while (element.next != null);
        }
        count--;
        return removedObject;
    }

    @Override
    public void wstaw(int i, E e) {
        if (i == 0) {
            Element<E> next = firstElement;
            firstElement = new Element<E>(e, next);
        } else {
            Element<E> previous = findElement(i - 1);
            Element<E> next = previous.next;
            previous.next = new Element<E>(e, next);
        }
        count++;
    }

    @Override
    public int szukaj(E e) {
        Element<E> element = firstElement;
        for (int i = 0; i < count; i++) {
            if (element.object.equals(e))
                return i;
            if (i < count - 1)
                element = element.next;
        }
        return -1;
    }

    @Override
    public E odczytaj(int i) {
        return findElement(i).object;
    }

    @Override
    public int rozmiar() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new WskaznikIterator<E>(firstElement);
    }
}
