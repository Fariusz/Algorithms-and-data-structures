package Collections.Lists.ArrayList;

import Collections.Lists.List;

import java.util.Iterator;

public class ArrayList<E> implements List, Iterable {

    Object[] array;
    int c = 0;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int i) {
        array = new Object[i];
    }

    private Object[] extendedArray() {
        Object[] tmpTab = new Object[array.length * 2];
        if (c >= 0) System.arraycopy(array, 0, tmpTab, 0, c);
        return tmpTab;
    }

    @Override
    public void add(Object o) {
        if (c >= array.length) {
            array = extendedArray();
        }
        array[c] = o;
        c++;
    }

    @Override
    public Object delete(int i) {
        if (i < c) {
            Object u = array[i];
            for (int j = i; j < c - 1; j++) {
                array[j] = array[j + 1];
            }
            c--;
            array[c] = null;
            return u;
        }
        return null;
    }

    @Override
    public void put(int i, Object o) {
        if (c >= array.length) {
            array = extendedArray();
        }
        for (int j = c; j > i; j--) {
            array[j] = array[j - 1];
        }
        array[i] = o;
        c++;
    }

    @Override
    public int find(Object o) {
        for (int i = 0; i < c; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int i) {
        if (i < c)
            return array[i];
        return -1;
    }

    @Override
    public int length() {
        return c;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(array);
    }

}
