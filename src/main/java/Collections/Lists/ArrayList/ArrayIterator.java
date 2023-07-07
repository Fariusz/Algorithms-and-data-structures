package Collections.Lists.ArrayList;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator {

    E[] array;
    int i;

    public ArrayIterator(E[] tablica) {
        this.array = tablica;
        i = -1;
    }

    @Override
    public boolean hasNext() {
        return (array[i + 1] != null && i + 1 < array.length);
    }

    @Override
    public E next() {
        if (i + 1 < array.length) {
            i++;
            return array[i];
        } else return null;
    }
}
