package DesignPatterns.Iterator;

import java.util.ArrayList;
import java.util.List;

// Step 1: Define the iterator interface
interface Iterator {
    boolean hasNext();

    Object next();
}

// Step 2: Implement the iterator class for a specific collection type
class ListIterator implements Iterator {
    private final List<Object> elements;
    private int position;

    public ListIterator(List<Object> elements) {
        this.elements = elements;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < elements.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Object element = elements.get(position);
            position++;
            return element;
        }
        return null;
    }
}

// Step 3: Implement the collection class
class MyCollection {
    private final List<Object> elements = new ArrayList<>();

    public void addElement(Object element) {
        elements.add(element);
    }

    public Iterator createIterator() {
        return new ListIterator(elements);
    }
}

// Step 4: Client code uses the iterator to iterate over the collection
class Main {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        collection.addElement("Element 1");
        collection.addElement("Element 2");
        collection.addElement("Element 3");

        Iterator iterator = collection.createIterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println(element);
        }
    }
}
