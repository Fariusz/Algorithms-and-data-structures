package Collections.Lists.LinkedList;

public class Element<E> {

    E object = null;
    Element<E> next = null;

    Element() {
    }

    Element(E object) {
        this.object = object;
    }

    Element(E object, Element element) {
        this.object = object;
        this.next = element;
    }
}

